package com.example.me.puslingmvp.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Me on 5/2/2017.
 */

public class GlideClient {
    public static void downloadImage (Context c, String imageUrl, ImageView img){
        Glide.with(c)
                .load(imageUrl)
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(img);
    }
}
