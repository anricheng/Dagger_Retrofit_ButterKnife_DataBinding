package com.example.aric.databinding.Service;


import com.example.aric.databinding.Model.ManhuaList;
import com.example.aric.databinding.Model.Student;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by aric on 16/5/30.
 */
public interface APIService {
    // "http://route.showapi.com/978-2?showapi_appid=20124&showapi_timestamp=20151214132239&showapi_sign=11e3a2b96eaa4c69944cd7dabd1cbbfb&page=1&"
    @GET("978-2")
    Observable<ManhuaList> loadsStudent(@Query("showapi_appid") String appid, @Query("showapi_sign")String sign, @Query("page")int  pageid);
}
