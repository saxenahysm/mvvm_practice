package com.test.milkcollection.response;


import com.google.gson.annotations.SerializedName;
import com.test.milkcollection.model.ImageItem;
import com.test.milkcollection.model.MilkItem;
import com.test.milkcollection.model.PageItem;

import java.util.ArrayList;
import java.util.List;

public class MilkURLResponse {

    @SerializedName("data1")
    public ArrayList<ImageItem> data = new ArrayList<>();

    public ArrayList<ImageItem> getImageItem() {
        return data;
    }

    public void setImageItem(ArrayList<ImageItem> data) {
        this.data = data;
    }

}
