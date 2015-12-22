package com.rotatestuff.aethernadev.rotatestuff.base.actionexecutor;

/**
 * Created by Aetherna on 22/12/2015.
 */
public interface UseCase<Result, Argument> {

    Result execute(Argument arg);
}
