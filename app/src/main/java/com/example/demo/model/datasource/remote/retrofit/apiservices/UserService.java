package com.example.demo.model.datasource.remote.retrofit.apiservices;

import com.example.demo.model.user.User;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserService {
    @GET("posts")
    Observable<List<User>>
    getUsers();

}
