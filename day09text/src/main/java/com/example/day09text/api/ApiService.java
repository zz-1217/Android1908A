package com.example.day09text.api;

import com.example.day09text.bean.Bean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface ApiService {
    String BaseUrl = "https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<Bean> getData();

    String downLoad = "http://yun918.cn/";
    @GET("study/public/res/UnknowApp-1.0.apk")
    @Streaming
    Observable<ResponseBody> downLoad();
}
