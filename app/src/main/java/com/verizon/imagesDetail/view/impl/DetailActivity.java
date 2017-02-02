package com.verizon.imagesDetail.view.impl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.verizon.R;
import com.verizon.imagesDetail.view.DetailView;
import com.verizon.imagesGrid.model.Datum;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailView  {
    @BindView(R.id.image) ImageView img;
    @BindView(R.id.pb) ProgressBar progressBar;
    private Datum item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Intent i = getIntent();
        item =  (Datum) i.getSerializableExtra("detail");
        Glide.with(DetailActivity.this).load(item.getArtist().getPictureXl()).into(img);
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
