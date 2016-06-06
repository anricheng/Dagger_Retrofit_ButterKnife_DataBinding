package com.example.aric.databinding;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

/**
 * Created by aric on 16/6/3.
 */
public class MyApplication extends Application{


    private AppComponent appComponent;


    public static MyApplication get(Context context){
        return (MyApplication)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }


}
