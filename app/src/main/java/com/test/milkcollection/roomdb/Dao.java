package com.test.milkcollection.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.test.milkcollection.model.MilkItem;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert
    void Insert(MilkDataModal milkModal);

    @Query("Select *from milk_table")
    LiveData<List<MilkDataModal>> getAllMilk();

}
