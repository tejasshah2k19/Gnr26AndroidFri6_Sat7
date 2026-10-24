package com.royal.service;

import com.royal.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApiService {
    @POST("/url-pattern")
    public Call<Object> signupApi(@Body UserModel userModel);

    @POST("/url-pattern")
    public Call<Object> loginApi(@Body UserModel userModel);
}
