package com.example.day06text2.api;

import com.example.day06text2.bean.InBean;

public interface InCallBack {
    void onSuccess(InBean bean);
    void onFail(String str);
}
