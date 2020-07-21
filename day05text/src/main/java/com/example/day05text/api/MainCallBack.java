package com.example.day05text.api;

import com.example.day05text.bean.Bean;

public interface MainCallBack {
    void onSuccess(Bean bean);
    void onFail(String str);
}
