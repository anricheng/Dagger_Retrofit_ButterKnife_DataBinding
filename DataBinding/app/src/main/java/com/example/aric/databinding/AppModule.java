package com.example.aric.databinding;

import com.example.aric.databinding.Model.ManhuaList;
import com.example.aric.databinding.Service.LoggerI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aric on 16/5/31.
 */
@Module
public class AppModule {
    MyApplication myApplication;
    public AppModule(MyApplication application) {
        this.myApplication= application;
    }

    @Singleton
    @Provides
    public MyApplication providerApplication(){
        return myApplication;
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new LoggerI()).build();
        return okHttpClient;
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
        String ENDPOINT = "http://route.showapi.com/";
        return new Retrofit.Builder().client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
}

