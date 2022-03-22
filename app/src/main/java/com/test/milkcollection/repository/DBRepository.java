package com.test.milkcollection.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.test.milkcollection.model.MilkItem;
import com.test.milkcollection.roomdb.Dao;
import com.test.milkcollection.roomdb.MilkDataModal;
import com.test.milkcollection.roomdb.MilkDatabase;

import java.util.List;

public class DBRepository {
    private Dao dao;
    LiveData<List<MilkDataModal>> allData;

    public DBRepository(Application application) {
        MilkDatabase milkdatabase= MilkDatabase.getInstance(application);
        dao = milkdatabase.Dao();
        this.allData = dao.getAllMilk();
    }

    public void insert(MilkDataModal modal){
        new InsertCourseAsyncTask(dao).execute(modal);
    }

    public LiveData<List<MilkDataModal>> getAllMilk(){
        return  allData;
    }

    private static class InsertCourseAsyncTask extends AsyncTask<MilkDataModal,Void,Void>{
        public Dao dao;

        private InsertCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(MilkDataModal... milkModals) {
            dao.Insert(milkModals[0]);
            return null;
        }
    }
}
