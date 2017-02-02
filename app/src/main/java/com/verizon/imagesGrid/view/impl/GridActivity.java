package com.verizon.imagesGrid.view.impl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.verizon.R;
import com.verizon.util.adapter.GridImgAdapter;
import com.verizon.imagesDetail.view.impl.DetailActivity;
import com.verizon.imagesGrid.model.Datum;
import com.verizon.imagesGrid.model.ImagesVO;
import com.verizon.imagesGrid.presenter.GridPresenter;
import com.verizon.imagesGrid.view.GridView;
import com.verizon.util.dagger.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridActivity extends AppCompatActivity implements GridView {
    public static final String PARAM = "E";
    @Inject GridPresenter gridPresenter;
    @BindView(R.id.recycler_grid) RecyclerView recyclerView;
    @BindView(R.id.progress_bar) ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        App.getAppComponent(this).inject(this);
        ButterKnife.bind(this);
        gridPresenter.attachView(this);
        getImagesList(PARAM);
    }

    @Override
    public ImagesVO getImagesList(String artist) {
        return gridPresenter.getImagesList(artist);
    }

    @Override
    public void createRecycler(List<Datum> data) {
        showProgress();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new GridImgAdapter(data, new GridImgAdapter.OnItemClickListener() {
            @Override public void onItemClick(Datum item) {
                Intent i = new Intent(GridActivity.this, DetailActivity.class);
                i.putExtra("detail", item);
                startActivity(i);
            }
        }));
        hideProgress();

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
