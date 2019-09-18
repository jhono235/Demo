package com.example.demo.presenter;

import com.example.demo.model.datasource.remote.retrofit.Network;
import com.example.demo.model.datasource.remote.retrofit.apiservices.UserService;
import com.example.demo.model.user.User;
import com.example.demo.view.MainActivityContract;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Presenter implements PresenterContract {
    private MainActivityContract mainActivityContract;
    private Network network;

    @Override
    public void bindView(MainActivityContract mainActivityContract) {
        this.mainActivityContract = mainActivityContract;

    }

    @Override
    public void unBind() {
        mainActivityContract = null;

    }

    @Override
    public void initNetworkCall() {
        network = new Network();
        UserService userService =
                network.getItems();
        userService
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<User> users) {
                        mainActivityContract.getListUsers(users);

                    }

                    @Override
                    public void onError(Throwable e) {
                        mainActivityContract.onError(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
