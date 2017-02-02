package com.verizon.util.dagger;



import com.verizon.imagesGrid.presenter.GridPresenter;
import com.verizon.imagesGrid.presenter.impl.GridPresenterImpl;
import com.verizon.imagesGrid.view.impl.GridActivity;
import com.verizon.util.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by memoPilgrim on 1/5/17.
 */
@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    GridPresenter provideGridPresenter(RetrofitHelper retrofitHelper) {
        return new GridPresenterImpl(retrofitHelper);
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper() {
        return new RetrofitHelper();
    }



}
