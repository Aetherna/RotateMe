package com.rotatestuff.aethernadev.rotatestuff.usecase;

import com.rotatestuff.aethernadev.rotatestuff.base.actionexecutor.UseCase;
import com.rotatestuff.aethernadev.rotatestuff.data.DataProvider;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Aetherna on 22/12/2015.
 */
@Singleton
public class GetDataUseCase implements UseCase<List<String>, Void> {

    private DataProvider dataProvider;

    @Inject
    public GetDataUseCase(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public List<String> execute(final Void arg) {
        return dataProvider.getSleepyData();
    }
}
