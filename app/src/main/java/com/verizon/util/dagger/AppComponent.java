package com.verizon.util.dagger;



import com.verizon.imagesGrid.presenter.GridPresenter;
import com.verizon.imagesGrid.view.impl.GridActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by memoPilgrim on 1/5/17.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    GridActivity inject(GridActivity activity);
}

