package com.verizon.imagesGrid.presenter.impl;


import android.content.Context;

import com.verizon.imagesGrid.model.ImagesVO;
import com.verizon.imagesGrid.presenter.GridPresenter;
import com.verizon.imagesGrid.view.GridView;
import com.verizon.imagesGrid.view.impl.GridActivity;
import com.verizon.util.RetrofitHelper;
import com.verizon.util.dagger.App;
import com.verizon.util.rest.ImgService;


import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by memoPilgrim on 14/12/16.
 */

public class GridPresenterImpl implements GridPresenter {
    @Inject RetrofitHelper retrofitHelper;
    ImagesVO imagesVO;
    GridView view;

    @Inject
    public GridPresenterImpl(RetrofitHelper retrofitHelper){
        this.retrofitHelper = retrofitHelper;
    }

    @Override
    public void attachView(GridView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }


    @Override
    public ImagesVO getImagesList(String artist) {
        ImgService imgService = retrofitHelper.create();
        Call<ImagesVO> callImg = imgService.getImagesList(artist);
        callImg.enqueue(new Callback<ImagesVO>() {
            @Override
            public void onResponse(Call<ImagesVO> call, Response<ImagesVO> response) {
                imagesVO = response.body();
                view.createRecycler(imagesVO.getData());
            }

            @Override
            public void onFailure(Call<ImagesVO> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return imagesVO;
    }
}
