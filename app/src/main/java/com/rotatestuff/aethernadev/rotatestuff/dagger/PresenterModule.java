package com.rotatestuff.aethernadev.rotatestuff.dagger;

import com.rotatestuff.aethernadev.rotatestuff.base.actionexecutor.UseCaseExecutor;
import com.rotatestuff.aethernadev.rotatestuff.data.DataProvider;
import com.rotatestuff.aethernadev.rotatestuff.presenter.MainActivityPresenter;
import com.rotatestuff.aethernadev.rotatestuff.usecase.GetDataUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 22/12/2015.
 */
@Module
public class PresenterModule {

    @Singleton
    @Provides
    MainActivityPresenter provideMainActivityPresenter(GetDataUseCase useCase, UseCaseExecutor executor) {
        return new MainActivityPresenter(useCase, executor);
    }
}
