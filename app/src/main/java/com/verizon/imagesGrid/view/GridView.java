package com.verizon.imagesGrid.view;

import android.content.Context;

import com.verizon.imagesGrid.model.Datum;
import com.verizon.imagesGrid.model.ImagesVO;
import com.verizon.util.BaseView;

import java.util.List;

/**
 * Created by memoPilgrim on 14/12/16.
 */

public interface GridView extends BaseView {
    ImagesVO getImagesList(String artist);
    void createRecycler(List<Datum> data);

}
