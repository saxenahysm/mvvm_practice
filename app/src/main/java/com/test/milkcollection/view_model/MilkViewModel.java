package com.test.milkcollection.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.test.milkcollection.MainActivity;
import com.test.milkcollection.repository.DBRepository;
import com.test.milkcollection.repository.MilkRepository;
import com.test.milkcollection.response.MilkResponse;
import com.test.milkcollection.response.MilkURLResponse;
import com.test.milkcollection.roomdb.MilkDataModal;

import static com.test.milkcollection.constants.AppConstant.API_KEY;
import static com.test.milkcollection.constants.AppConstant.ARTICLE_QUERY;


public class MilkViewModel extends AndroidViewModel {

    private MilkRepository milkRepository;
    private LiveData<MilkResponse> milkResponseLiveData;
    private LiveData<MilkURLResponse> milkResponseLiveDataImage;
    private DBRepository dbRepository;
    public MilkViewModel(@NonNull Application application) {
        super(application);
        milkRepository = new MilkRepository();
        dbRepository= new DBRepository(application);
        this.milkResponseLiveData = milkRepository.getMilkList("75", String.valueOf(MainActivity.page));
        this.milkResponseLiveDataImage = milkRepository.getMilkURLList("75");
    }

    public LiveData<MilkResponse> getMilkResponseLiveData() {
        return milkResponseLiveData;
    }

    public LiveData<MilkURLResponse> getMilkResponseLiveDataImage() {
        return milkResponseLiveDataImage;
    }

    public void insert(MilkDataModal modal){
        dbRepository.insert(modal);
    }
}
