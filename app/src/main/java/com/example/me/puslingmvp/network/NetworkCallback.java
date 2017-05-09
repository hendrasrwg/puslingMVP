package com.example.me.puslingmvp.network;

import android.util.Log;

import java.util.List;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by Me on 5/1/2017.
 */

public abstract class NetworkCallback<T> extends Subscriber<T> {

    private static final String TAG = NetworkCallback.class.getName();

    public abstract void onSuccess2(T model);

    public abstract void onFailure(String message);

    public abstract void onFinish();


    @Override
    public void onCompleted() {
        onFinish();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String message = httpException.getMessage();
            Log.i(TAG, "code : " + code);
            onFailure(message);

        } else {
            onFailure(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onNext(T model) {
        onSuccess2(model);
    }
}
