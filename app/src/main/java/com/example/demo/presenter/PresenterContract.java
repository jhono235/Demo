package com.example.demo.presenter;

import com.example.demo.view.MainActivityContract;

public interface PresenterContract {
    void bindView(MainActivityContract mainActivityContract);
    void unBind();
    void initNetworkCall();
}
