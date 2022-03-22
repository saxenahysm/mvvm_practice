package com.test.milkcollection.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.milkcollection.MainActivity;
import com.test.milkcollection.R;
import com.test.milkcollection.model.MilkItem;

import java.util.ArrayList;

public class MilkAdapter extends RecyclerView.Adapter<MilkAdapter.ViewHolder> {

    private Context context;
    ArrayList<MilkItem> milkArrayList;

    public MilkAdapter(Context context, ArrayList<MilkItem> milkArrayList) {
        this.context = context;
        this.milkArrayList = milkArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main_child,viewGroup,false);
        return new ViewHolder(view);
    }

    int j=0;
    MilkItem milk;
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        milk=milkArrayList.get(i);
        int sn =i+1;

        if (i%3 == 0) {
            viewHolder.textView_name.setTextColor(Color.parseColor("#FF03DAC5"));

        } else if (i%3 == 1) {
            viewHolder.textView_name.setTextColor(Color.parseColor("#FF6200EE"));

        } else if (i%3 == 2) {
            viewHolder.textView_name.setTextColor(Color.parseColor("#FF000000"));

        }

        if (i%3 == 0) {
            viewHolder.linear_bg.setBackgroundColor(Color.parseColor("#DA312D"));

        } else if (i%3 == 1) {
            viewHolder.linear_bg.setBackgroundColor(Color.parseColor("#3C54E1"));

        } else if (i%3 == 2) {
            viewHolder.linear_bg.setBackgroundColor(Color.parseColor("#43A047"));

        }

        viewHolder.textView_sn.setText(String.valueOf(sn));
        viewHolder.textView_name.setText(milk.getFName());
        viewHolder.textView_vill.setText(milk.getVillageName());
        viewHolder.textView_route.setText(milk.getRouteName());
        viewHolder.setIsRecyclable(true);

        viewHolder.Main_Linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context, R.style.MyAlertDialogTheme);
                dialog.setContentView(R.layout.dialog_for_alerts);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                Button btnCancel= (Button) dialog.findViewById(R.id.btnCancel);
                Button btnOk= (Button) dialog.findViewById(R.id.btnOk);
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        milk=milkArrayList.get(i);
                        dialog.dismiss();
                        ((MainActivity)context).savedata(milk.FName,milk.VillageName,milk.RouteName);
                    }
                });
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return milkArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView_sn;
        private final TextView textView_name;
        private final TextView textView_vill;
        private final TextView textView_route;
        private final LinearLayout Main_Linear;
        private final LinearLayout linear_bg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_sn= itemView.findViewById(R.id.tv_sn);
            textView_name= itemView.findViewById(R.id.tv_name);
            textView_vill=itemView.findViewById(R.id.tv_vill);
            textView_route= itemView.findViewById(R.id.tv_route);
            Main_Linear= itemView.findViewById(R.id.Main_Linear);
            linear_bg= itemView.findViewById(R.id.linear_bg);
        }
    }
}
