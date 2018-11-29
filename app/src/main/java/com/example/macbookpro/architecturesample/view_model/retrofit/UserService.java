package com.example.macbookpro.architecturesample.view_model.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET("/users")
    Call<List<User>> getAllUser();
}
