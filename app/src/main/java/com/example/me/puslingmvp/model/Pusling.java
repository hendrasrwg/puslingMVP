package com.example.me.puslingmvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Me on 5/1/2017.
 */

public class Pusling {

    @SerializedName("Judul_buku")
    private String judul;

    @SerializedName("cover")
    private String cover;


    public String getJudul() {
        return judul;
    }

    public String getCover() {
        return cover;
    }
}
