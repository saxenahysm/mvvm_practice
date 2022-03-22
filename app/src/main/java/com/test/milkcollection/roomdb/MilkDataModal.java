package com.test.milkcollection.roomdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "milk_table")
public class MilkDataModal {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String village;
    String route;

    public MilkDataModal(String name, String village, String route) {
        this.name = name;
        this.village = village;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
