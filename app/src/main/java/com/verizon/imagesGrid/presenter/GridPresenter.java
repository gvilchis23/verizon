package com.verizon.imagesGrid.presenter;


import android.content.Context;

import com.verizon.imagesGrid.model.ImagesVO;
import com.verizon.imagesGrid.view.GridView;
import com.verizon.util.BasePresenter;

/**
 * Created by memoPilgrim on 14/12/16.
 */

public interface GridPresenter extends BasePresenter<GridView> {
    ImagesVO getImagesList(String artist);
}
