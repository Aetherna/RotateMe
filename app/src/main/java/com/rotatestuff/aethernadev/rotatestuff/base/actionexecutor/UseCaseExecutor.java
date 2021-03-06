package com.rotatestuff.aethernadev.rotatestuff.base.actionexecutor;


import rx.Observable;

/**
 * Created by Aetherna on 22/12/2015.
 */
public interface UseCaseExecutor {

      <Result, Argument> Observable<Result> wrap(UseCase<Result, Argument> useCase, Argument argument);

}
