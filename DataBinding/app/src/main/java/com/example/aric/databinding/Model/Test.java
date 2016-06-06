package com.example.aric.databinding.Model;

import android.content.Context;

import com.example.aric.databinding.Model.AppInfo;
import com.example.aric.databinding.Utils.AppUtil;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by aric on 16/5/30.
 */
public class Test {

    public Observable<List<AppInfo>> getListByRxJava(final Context context){
        Observable<List<AppInfo>> observer = Observable.create(
                new Observable.OnSubscribe<List<AppInfo>>() {
                    @Override
                    public void call(Subscriber<? super List<AppInfo>> subscriber) {
                        List<AppInfo> infoList = AppUtil.getAppList(context);
                        subscriber.onNext(infoList);
                        subscriber.onCompleted();
                    }
                });
        return observer;
    }
}
