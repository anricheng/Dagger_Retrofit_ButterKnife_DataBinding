package com.example.aric.databinding;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by aric on 16/6/3.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity mainActivity);

    Retrofit retrofit();
}
