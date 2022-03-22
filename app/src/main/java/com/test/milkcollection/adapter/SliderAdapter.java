package com.test.milkcollection.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;
import com.test.milkcollection.R;
import com.test.milkcollection.model.ImageItem;
import com.test.milkcollection.model.MilkItem;

import java.util.ArrayList;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    ArrayList<ImageItem> milkArrayList;

    public SliderAdapter(Context context, ArrayList<ImageItem> milkArrayList) {
        this.context = context;
        this.milkArrayList = milkArrayList;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_child, null);
        return new SliderAdapterVH(inflate);
    }

    ImageItem product;

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        product=milkArrayList.get(position);
        try {


             Picasso.get().load("http://dairyerpservice.eanifarm.com/Images/Banner/b1.jpg").into(viewHolder.imageViewBackground);
           // Log.e("ImagePath",product.getImagepath());
           // Glide.with(context).load("http://dairyerpservice.eanifarm.com/Images/Banner/b1.jpg").into(viewHolder.imageViewBackground);
        }catch (Exception e){
            e.printStackTrace();
        }
        viewHolder.imageViewBackground.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }




    @Override
    public int getCount() {
        return milkArrayList.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        ImageView imageViewBackground;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.image);
        }
    }
}

