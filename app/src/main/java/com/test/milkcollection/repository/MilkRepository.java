package com.test.milkcollection.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.test.milkcollection.response.MilkResponse;
import com.test.milkcollection.response.MilkURLResponse;
import com.test.milkcollection.retrofit.ApiRequest;
import com.test.milkcollection.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MilkRepository {
    private static final String TAG = "Milk";
    private ApiRequest apiRequest;

    public MilkRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<MilkResponse> getMilkList(String userid, String pageno) {
        final MutableLiveData<MilkResponse> data = new MutableLiveData<>();
        apiRequest.getMilkDetails(userid, pageno)
                .enqueue(new Callback<MilkResponse>() {
                    @Override
                    public void onResponse(Call<MilkResponse> call, Response<MilkResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                            Log.d(TAG, "total result:: " + response.body().getMilkItem());
                        }
                    }
                    @Override
                    public void onFailure(Call<MilkResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public LiveData<MilkURLResponse> getMilkURLList(String userid) {
        final MutableLiveData<MilkURLResponse> data = new MutableLiveData<>();
        apiRequest.getMilkImageDetails(userid)
                .enqueue(new Callback<MilkURLResponse>() {
                    @Override
                    public void onResponse(Call<MilkURLResponse> call, Response<MilkURLResponse> response) {
                        Log.d(TAG, "onResponse responseurl:: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<MilkURLResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
