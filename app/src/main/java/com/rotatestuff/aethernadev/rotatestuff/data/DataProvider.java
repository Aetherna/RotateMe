package com.rotatestuff.aethernadev.rotatestuff.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Aetherna on 22/12/2015.
 */
@Singleton
public class DataProvider {

    @Inject
    public DataProvider() {
    }

    public List<String> getSleepyData() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<String> data = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            data.add(getRandomText());
        }
        return data;
    }


    private String getRandomText() {
        return "Text" + new Random().nextInt(100);
    }

}
