package com.example.me.puslingmvp.feature.home;

import com.example.me.puslingmvp.model.DataPusling;
import com.example.me.puslingmvp.model.Pusling;

import java.util.List;

/**
 * Created by Me on 5/1/2017.
 */

interface MainView {
    void showLoading();

    void hideLoading();

    void getDataSuccess(List<Pusling> model);

    void getDataFail(String message);
}
