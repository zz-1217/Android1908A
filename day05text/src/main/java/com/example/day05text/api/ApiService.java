package com.example.day05text.api;

import com.example.day05text.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    String baseUrl = "http://c.m.163.com/nc/article/";
    @GET("headline/T1348647909107/0-20.html")
    Observable<Bean> getData();
}
