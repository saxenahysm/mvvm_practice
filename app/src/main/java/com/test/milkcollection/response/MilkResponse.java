package com.test.milkcollection.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.test.milkcollection.model.MilkItem;
import com.test.milkcollection.model.PageItem;

import java.util.ArrayList;
import java.util.List;

public class MilkResponse {

    @SerializedName("data1")
    public List<MilkItem> data = new ArrayList<>();

    public List<MilkItem> getMilkItem() {
        return data;
    }

    public void setMilkItem(List<MilkItem> data) {
        this.data = data;
    }

    @SerializedName("data2")
    public List<PageItem> datapage = new ArrayList<>();

    public List<PageItem> getPageItem() {
        return datapage;
    }

    public void setPageItem(List<PageItem> datapage) {
        this.datapage = datapage;
    }


}
