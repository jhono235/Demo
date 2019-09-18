package com.example.demo.model.datasource.remote.retrofit;

import com.example.demo.model.datasource.remote.retrofit.apiservices.UserService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    public UserService getItems(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);
        return userService;
    }
}
