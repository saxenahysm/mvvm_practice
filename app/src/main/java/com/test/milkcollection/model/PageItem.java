package com.test.milkcollection.model;

import com.google.gson.annotations.SerializedName;

public class PageItem {

    @SerializedName("PageNo")
    public String PageNo;

    @SerializedName("TotalCount")
    public String TotalCount;


    public String getPageNo() {
        return PageNo;
    }

    public void setPageNo(String pageNo) {
        PageNo = pageNo;
    }

    public String getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(String totalCount) {
        TotalCount = totalCount;
    }
}
