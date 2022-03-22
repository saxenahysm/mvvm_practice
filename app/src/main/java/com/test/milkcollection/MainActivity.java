package com.test.milkcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;
import com.test.milkcollection.adapter.MilkAdapter;
import com.test.milkcollection.adapter.SliderAdapter;
import com.test.milkcollection.model.ImageItem;
import com.test.milkcollection.model.MilkItem;
import com.test.milkcollection.roomdb.MilkDataModal;
import com.test.milkcollection.view_model.MilkViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView my_recycler_view;
    private ProgressBar progress_circular;
    private LinearLayoutManager layoutManager;
    private MilkAdapter adapter;
    private ImageView imageViewHeader;
    private ArrayList<MilkItem> milkArrayList = new ArrayList<>();
    MilkViewModel milkViewModel;
    SliderView sliderView;
    private NestedScrollView nestedSV;
    public static int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initialization();
        getMilkDetails();
        getMilkImagesDetails();
        nestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    page++;
                    progress_circular.setVisibility(View.VISIBLE);
                    getMilkDetails();
                }
            }
        });    }

    private void initialization() {
        nestedSV=findViewById(R.id.idNestedSV);
        sliderView =findViewById(R.id.imageSlider);
        progress_circular =  findViewById(R.id.progress_circular);
        my_recycler_view =  findViewById(R.id.my_recycler_view);

        layoutManager = new LinearLayoutManager(MainActivity.this);
        my_recycler_view.setLayoutManager(layoutManager);

        my_recycler_view.setHasFixedSize(true);

        adapter = new MilkAdapter(MainActivity.this, milkArrayList);
        my_recycler_view.setAdapter(adapter);

        milkViewModel = ViewModelProviders.of(this).get(MilkViewModel.class);
    }


    private void getMilkDetails() {
        milkViewModel.getMilkResponseLiveData().observe(this, milkResponse -> {
            if (milkResponse != null) {
                progress_circular.setVisibility(View.GONE);
                List<MilkItem> milks = milkResponse.getMilkItem();
                milkArrayList.addAll(milks);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void getMilkImagesDetails() {
        milkViewModel.getMilkResponseLiveDataImage().observe(this, milkResponse -> {
            if (milkResponse != null) {
                Log.e("milkResponse",milkResponse.toString());
               // progress_circular.setVisibility(View.GONE);
                ArrayList<ImageItem> milks = milkResponse.getImageItem();
                if(milks.size()>0){
                    SliderAdapter adapter = new SliderAdapter(this,milks);
                    sliderView.setSliderAdapter(adapter);
                    sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
                    sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
                    sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
                    sliderView.setIndicatorSelectedColor(Color.WHITE);
                    sliderView.setIndicatorUnselectedColor(Color.GRAY);
                    sliderView.setScrollTimeInSec(6); //set scroll delay in seconds :
                    sliderView.startAutoCycle();
                }
            }
        });
    }

    public void savedata(String name,String vill,String route){
        MilkDataModal model = new MilkDataModal(name, vill, route);
        milkViewModel.insert(model);
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }
}