package com.example.me.puslingmvp.feature.home;

import com.example.me.puslingmvp.base.ui.BasePresenter;
import com.example.me.puslingmvp.model.DataPusling;
import com.example.me.puslingmvp.model.Pusling;
import com.example.me.puslingmvp.network.NetworkCallback;

import java.util.List;

/**
 * Created by Me on 5/1/2017.
 */

class MainPresenter extends BasePresenter<MainView> {
    MainPresenter(MainView view){
        super.attachView(view);
    }

    void loadData()
    {
        view.showLoading();
        addSubscribe(apiStores.getJSON("000","999"), new NetworkCallback<List<Pusling>>() {

            @Override
            public void onSuccess2(List<Pusling> model) {
                view.getDataSuccess(model);
            }

            @Override
            public void onFailure(String message) {
                view.getDataFail(message);
            }

            @Override
            public void onFinish() {
                view.hideLoading();
            }
        });
    }

    void search(String katakunci){
        view.showLoading();
        addSubscribe(apiStores.filter(katakunci, "Judul_buku"), new NetworkCallback<List<Pusling>>() {
            @Override
            public void onSuccess2(List<Pusling> model) {
                view.getDataSuccess(model);
            }

            @Override
            public void onFailure(String message) {
                view.getDataFail(message);
            }

            @Override
            public void onFinish() {
                view.hideLoading();
            }
        });
    }

}
