package com.example.me.puslingmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.me.puslingmvp.helper.GlideClient;
import com.example.me.puslingmvp.model.Pusling;
import com.example.me.puslingmvp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Me on 4/29/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Pusling> pusling;
    Context c;

    public Adapter(List<Pusling> pusling, Context c) {
        this.pusling = pusling;
        this.c = c;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        GlideClient.downloadImage(c,pusling.get(position).getCover(),holder.img);
        holder.judul.setText(pusling.get(position).getJudul());
    }

    @Override
    public int getItemCount() {
        return pusling.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.img)
       ImageView img;
        @BindView(R.id.txtJudul)
        TextView judul;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

}
