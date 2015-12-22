package com.rotatestuff.aethernadev.rotatestuff.base.async;

import com.rotatestuff.aethernadev.rotatestuff.base.actionexecutor.UseCase;
import com.rotatestuff.aethernadev.rotatestuff.base.actionexecutor.UseCaseExecutor;

import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Aetherna on 22/12/2015.
 */
@Singleton
public class AsyncUseCaseExecutor implements UseCaseExecutor {
    @Override
    public <Result, Argument> Observable<Result> wrap(final UseCase<Result, Argument> useCase, final Argument argument) {

        return Observable.create(new Observable.OnSubscribe<Result>() {
            @Override
            public void call(final Subscriber<? super Result> subscriber) {
                try {
                    subscriber.onNext(useCase.execute(argument));
                    subscriber.onCompleted();
                } catch (Exception ex) {
                    subscriber.onError(ex);
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
