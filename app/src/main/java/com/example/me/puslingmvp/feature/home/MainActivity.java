package com.example.me.puslingmvp.feature.home;

import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.me.puslingmvp.R;
import com.example.me.puslingmvp.adapter.Adapter;
import com.example.me.puslingmvp.base.mvp.MvpActivity;
import com.example.me.puslingmvp.model.DataPusling;
import com.example.me.puslingmvp.model.Pusling;
import com.github.clans.fab.FloatingActionMenu;
import com.github.fabtransitionactivity.SheetLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView,SearchView.OnQueryTextListener {
    ProgressDialog progressDialog;

    MenuItem menuItem;
    SearchView mSearchView;

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected MainPresenter createPresenter() {
       return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        rv.setItemAnimator(new DefaultItemAnimator());
        presenter.loadData();
    }

    @Override
    public void showLoading() {
        progressDialog= new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("loading");
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.hide();
    }

    @Override
    public void getDataSuccess(List<Pusling> model) {
        Adapter adapter= new Adapter(model,MainActivity.this);
        rv.setAdapter(adapter);
    }

    @Override
    public void getDataFail(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menuItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) menuItem.getActionView();
        MenuItemCompat.expandActionView(menuItem); /* auto focus */
        MenuItemCompat.setOnActionExpandListener(menuItem, new MenuItemCompat.OnActionExpandListener(){
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                onBackPressed();
                return false;
            }
        });

        mSearchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        presenter.search(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.toString().equals("")){
            presenter.loadData();
        }
        return false;
    }

}
