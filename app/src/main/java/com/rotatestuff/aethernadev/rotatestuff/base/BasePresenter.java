package com.rotatestuff.aethernadev.rotatestuff.base;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Aetherna on 22/12/2015.
 */
public abstract class BasePresenter<UI> {

    UI ui;
    Queue<UIAction<UI>> uiActions = new LinkedList<>();

    public void attachUI(UI ui) {
        this.ui = ui;
        executeWaitingActions();
    }

    public void detachUI() {
        this.ui = null;
    }

    public void execute(UIAction<UI> uiAction) {
        uiActions.add(uiAction);
        executeWaitingActions();
    }

    private void executeWaitingActions() {
        if (ui == null) {
            return;
        }

        UIAction action;
        while ((action = uiActions.poll()) != null) {
            action.execute(ui);
        }
    }

}
