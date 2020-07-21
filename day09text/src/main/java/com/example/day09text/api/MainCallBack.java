package com.example.day09text.api;

import com.example.day09text.bean.Bean;

public interface MainCallBack {
    void onSuccess(Bean bean);
    void onFail(String str);
}
