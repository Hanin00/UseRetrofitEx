package com.example.useretrofitex.addr;

import com.example.useretrofitex.addr.model.AddressResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AddressRetrofitInterface {

    @POST("/data/address")
    Call<List<AddressResponse>> getPosts(@Query("address") String addr);

}