package com.test.milkcollection.roomdb;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {MilkDataModal.class}, version = 1)
public abstract class MilkDatabase extends RoomDatabase {

    private static MilkDatabase instance;

    public abstract Dao Dao();

    public static synchronized MilkDatabase getInstance(Context context) {

        if (instance == null) {

            instance =
                    Room.databaseBuilder(context.getApplicationContext(),
                            MilkDatabase.class, "milk_database")

                            .fallbackToDestructiveMigration()

                            .addCallback(roomCallback)

                            .build();
        }

        return instance;
    }


    private static Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateDbAsyncTask(instance).execute();
        }
    };


    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        PopulateDbAsyncTask(MilkDatabase instance) {
            Dao dao = instance.Dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
