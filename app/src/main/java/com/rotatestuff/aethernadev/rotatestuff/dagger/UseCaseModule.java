package com.rotatestuff.aethernadev.rotatestuff.dagger;

import com.rotatestuff.aethernadev.rotatestuff.base.actionexecutor.UseCaseExecutor;
import com.rotatestuff.aethernadev.rotatestuff.base.async.AsyncUseCaseExecutor;
import com.rotatestuff.aethernadev.rotatestuff.data.DataProvider;
import com.rotatestuff.aethernadev.rotatestuff.usecase.GetDataUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 22/12/2015.
 */
@Module
public class UseCaseModule {

    @Singleton
    @Provides
    GetDataUseCase provideGetDataUseCase(DataProvider dataProvider) {
        return new GetDataUseCase(dataProvider);
    }

    @Singleton
    @Provides
    UseCaseExecutor provideUseCaseExecutor() {
        return new AsyncUseCaseExecutor();
    }
}
