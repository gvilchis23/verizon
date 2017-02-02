package com.verizon.util.rest;


import com.verizon.imagesGrid.model.ImagesVO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


/**
 * Created by memoPilgrim on 13/12/16.
 */

public interface ImgService {

    @Headers({
            "X-Mashape-Key:XyEFiwr6KLmshHAps1Q3ctaSWsD4p1QgDygjsnuzHifnblPAXn",
            "Accept:text/plain"
    })
    @GET("search")
    Call<ImagesVO> getImagesList(@Query("q") String artist);

}
