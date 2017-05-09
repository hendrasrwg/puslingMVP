package com.example.me.puslingmvp.network;

import com.example.me.puslingmvp.model.DataPusling;
import com.example.me.puslingmvp.model.Pusling;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Me on 5/1/2017.
 */

public interface NetworkStores {

    @FormUrlEncoded
    @POST("pusling/ambildata3.php")
    Observable<List<Pusling>> getJSON(@Field("Query") String batasawal, @Field("Query2") String batasakhir);

    @FormUrlEncoded
    @POST("pusling/search.php")
    Observable<List<Pusling>> filter (@Field("Query") String kataKunci, @Field("Query2") String berdasarkan);
}
