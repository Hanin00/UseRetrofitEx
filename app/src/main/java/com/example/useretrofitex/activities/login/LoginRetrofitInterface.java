package com.example.useretrofitex.activities.login;

import com.example.useretrofitex.activities.addr.model.AddressResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginRetrofitInterface {

    @FormUrlEncoded
    @POST("/user/")
    //Call<List<LoginResponse>> getLogins(@Query("my_id") String myId,
    Call<LoginResponse> getLogins(@Field("my_id") String my_id, @Field("password") String password);
}
