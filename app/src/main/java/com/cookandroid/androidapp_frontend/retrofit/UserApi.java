package com.cookandroid.androidapp_frontend.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

//user정보 백으로
public interface UserApi {

    @POST("/signin")
    Call<Boolean> postUser(@Body UserVO userVO);

}
