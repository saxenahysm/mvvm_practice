package com.test.milkcollection.model;

import com.google.gson.annotations.SerializedName;

public class MilkItem {

    @SerializedName("FName")
    public String FName;

    @SerializedName("VillageName")
    public String VillageName;

    @SerializedName("RouteName")
    public String RouteName;

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getVillageName() {
        return VillageName;
    }

    public void setVillageName(String villageName) {
        VillageName = villageName;
    }

    public String getRouteName() {
        return RouteName;
    }

    public void setRouteName(String routeName) {
        RouteName = routeName;
    }
}
