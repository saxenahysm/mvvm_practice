package com.test.milkcollection.model;

import com.google.gson.annotations.SerializedName;

public class ImageItem {

    @SerializedName("imagepath")
    public String imagepath;

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
}
