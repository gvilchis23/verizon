package com.verizon.imagesDetail.presenter.impl;


import com.verizon.imagesDetail.presenter.DetailPresenter;
import com.verizon.imagesDetail.view.DetailView;

import javax.inject.Inject;

/**
 * Created by memoPilgrim on 14/12/16.
 */

public class DetailPresenterImpl implements DetailPresenter {
    DetailView view;
    @Inject
    public DetailPresenterImpl(){
    }

    @Override
    public void attachView(DetailView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
