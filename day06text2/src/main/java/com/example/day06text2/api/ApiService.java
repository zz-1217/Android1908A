package com.example.day06text2.api;

import com.example.day06text2.bean.InBean;
import com.example.day06text2.bean.PeopleBean;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    String basePeopleUrl = "https://api.yunxuekeji.cn/yunxue_app_api/";
    @GET("content/getData/30/66597/1/10")
    Observable<PeopleBean> getPeopleData();

    String baseInUrl = "https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/teacher/getTeacherPower/{ID}")
    Observable<InBean> getInData(@Path("ID") int id);
}
