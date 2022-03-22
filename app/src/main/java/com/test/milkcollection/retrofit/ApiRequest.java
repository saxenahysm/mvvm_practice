package com.test.milkcollection.retrofit;

import com.test.milkcollection.response.MilkResponse;
import com.test.milkcollection.response.MilkURLResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("GetCustomerRegisteredByApp_1_0")
    Call<MilkResponse> getMilkDetails(
            @Query("UserId") String UserId,
            @Query("PageNo") String PageNo
    );

    @GET("Sp_Get_Appimages_CA_1_0")
    Call<MilkURLResponse> getMilkImageDetails(
            @Query("UserId") String UserId
    );
}
