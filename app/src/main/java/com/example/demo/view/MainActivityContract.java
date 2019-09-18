package com.example.demo.view;

import com.example.demo.model.user.User;

import java.util.List;

public interface MainActivityContract {
    void getListUsers(List<User> dataSet);
    void initUi();
    void onError(String error);
}
