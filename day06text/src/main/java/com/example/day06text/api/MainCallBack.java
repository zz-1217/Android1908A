package com.example.day06text.api;

import com.example.day06text.bean.Bean;

public interface MainCallBack {
    void onSuccess(Bean bean);
    void onFail(String str);
}
