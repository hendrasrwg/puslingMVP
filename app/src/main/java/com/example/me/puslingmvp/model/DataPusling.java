package com.example.me.puslingmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Me on 5/1/2017.
 */

public class DataPusling {

    @SerializedName("tbbuku")
    @Expose
    public List<Pusling> puslings = null;

    public List<Pusling> getPuslings() {
        return puslings;
    }

    public void setPuslings(List<Pusling> puslings) {
        this.puslings = puslings;
    }
}
