package com.rotatestuff.aethernadev.rotatestuff.presenter;

import com.rotatestuff.aethernadev.rotatestuff.SyncUseCaseExecutor;
import com.rotatestuff.aethernadev.rotatestuff.base.actionexecutor.UseCaseExecutor;
import com.rotatestuff.aethernadev.rotatestuff.dagger.AppComponent;
import com.rotatestuff.aethernadev.rotatestuff.usecase.GetDataUseCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 22/12/2015.
 */
public class MainPresenterTest {

    TestAppComponent testAppComponent;

    @Inject
    MainActivityPresenter testObject;
    @Inject
    GetDataUseCase mockedUseCase;
    @Mock
    MainActivityPresenter.MainUI ui;


    @Before
    public void setUp() throws Exception {

        testAppComponent = DaggerMainPresenterTest_TestAppComponent.builder().build();
        testAppComponent.inject(this);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldShowDataOnAttachedUI() {
        Assert.assertTrue(testObject != null);

        //having
        List<String> mockData = new ArrayList<>();
        Mockito.when(mockedUseCase.execute(null)).thenReturn(mockData);

        testObject.attachUI(ui);

        //when
        testObject.loadDataToShow();

        //then
        Mockito.verify(ui, Mockito.times(1)).showData(mockData);
    }

    @Test
    public void shouldNotShowDataOnDetachedUI() {
        Assert.assertTrue(testObject != null);

        //having
        List<String> mockData = new ArrayList<>();
        Mockito.when(mockedUseCase.execute(null)).thenReturn(mockData);

        testObject.detachUI();

        //when
        testObject.loadDataToShow();

        //then
        Mockito.verifyZeroInteractions(ui);
    }

    @Test
    public void shouldShowDataWhenUIAttaches() {
        Assert.assertTrue(testObject != null);

        //having
        List<String> mockData = new ArrayList<>();
        Mockito.when(mockedUseCase.execute(null)).thenReturn(mockData);

        testObject.detachUI();
        testObject.loadDataToShow();

        //when
        testObject.attachUI(ui);

        //then
        Mockito.verify(ui, Mockito.times(1)).showData(mockData);
    }

    @Singleton
    @Component(modules = {TestUseCaseModule.class})
    interface TestAppComponent extends AppComponent {
        void inject(MainPresenterTest mainPresenterTest);
    }

    @Module
    static class TestUseCaseModule {
        @Singleton
        @Provides
        UseCaseExecutor provideUseCaseExecutor() {
            return new SyncUseCaseExecutor();
        }

        @Singleton
        @Provides
        GetDataUseCase provideMockGetDataUseCase() {
            return Mockito.mock(GetDataUseCase.class);
        }
    }

}
