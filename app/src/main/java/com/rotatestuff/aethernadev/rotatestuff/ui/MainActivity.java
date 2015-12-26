package com.rotatestuff.aethernadev.rotatestuff.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.rotatestuff.aethernadev.rotatestuff.R;
import com.rotatestuff.aethernadev.rotatestuff.application.App;
import com.rotatestuff.aethernadev.rotatestuff.presenter.MainActivityPresenter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends ActionBarActivity implements MainActivityPresenter.MainUI {

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getAppComponent().inject(this);

        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                presenter.onGoButtonClick();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachUI(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.detachUI();
    }

    @Override
    public void showData(final List<String> data) {
        TextView tv = (TextView) findViewById(R.id.text_view);
        for (String string : data) {
            tv.append(" " + string);
        }
    }
}
