package com.rotatestuff.aethernadev.rotatestuff.application;

import android.app.Application;

import com.rotatestuff.aethernadev.rotatestuff.dagger.AppComponent;
import com.rotatestuff.aethernadev.rotatestuff.dagger.DaggerAppComponent;

/**
 * Created by Aetherna on 22/12/2015.
 */
public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
