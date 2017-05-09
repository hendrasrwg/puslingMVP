package com.example.me.puslingmvp.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.me.puslingmvp.base.ui.BaseActivity;
import com.example.me.puslingmvp.base.ui.BasePresenter;

/**
 * Created by Me on 5/1/2017.
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P presenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        presenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettachView();
        }
    }
}