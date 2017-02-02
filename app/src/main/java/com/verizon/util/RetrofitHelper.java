package com.verizon.util;

import com.verizon.util.rest.ImgService;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by memoPilgrim on 2/1/17.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "https://deezerdevs-deezer.p.mashape.com/";

    @Inject
    public RetrofitHelper(){

    }

    public ImgService create(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        ImgService service = retrofit.create(ImgService.class);
        return service;

    }
}
