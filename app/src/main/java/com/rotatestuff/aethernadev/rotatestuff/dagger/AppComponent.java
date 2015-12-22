package com.rotatestuff.aethernadev.rotatestuff.dagger;

import com.rotatestuff.aethernadev.rotatestuff.presenter.MainActivityPresenter;
import com.rotatestuff.aethernadev.rotatestuff.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aetherna on 22/12/2015.
 */
@Singleton
@Component(modules = {UseCaseModule.class, PresenterModule.class})
public interface AppComponent {

    MainActivityPresenter mainActivityPresenter();

    void inject(MainActivity mainActivity);
}
