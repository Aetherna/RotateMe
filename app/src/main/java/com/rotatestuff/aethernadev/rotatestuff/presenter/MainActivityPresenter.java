package com.rotatestuff.aethernadev.rotatestuff.presenter;

import com.rotatestuff.aethernadev.rotatestuff.base.BasePresenter;
import com.rotatestuff.aethernadev.rotatestuff.base.UIAction;
import com.rotatestuff.aethernadev.rotatestuff.base.actionexecutor.UseCaseExecutor;
import com.rotatestuff.aethernadev.rotatestuff.usecase.GetDataUseCase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.functions.Action1;

/**
 * Created by Aetherna on 22/12/2015.
 */
@Singleton
public class MainActivityPresenter extends BasePresenter<MainActivityPresenter.MainUI> {

    GetDataUseCase useCase;
    UseCaseExecutor useCaseExecutor;

    @Inject
    public MainActivityPresenter(final GetDataUseCase useCase, final UseCaseExecutor useCaseExecutor) {
        this.useCase = useCase;
        this.useCaseExecutor = useCaseExecutor;
    }

    public void onGoButtonClick() {
        useCaseExecutor.wrap(useCase, null).subscribe(new Action1<List<String>>() {
            @Override
            public void call(final List<String> data) {
                execute(new UIAction<MainUI>() {
                    @Override
                    public void execute(final MainUI mainUI) {
                        mainUI.showData(data);
                    }
                });
            }
        });
    }


    public interface MainUI {
        void showData(List<String> data);
    }
}
