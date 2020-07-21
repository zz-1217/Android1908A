package com.example.day06text2.api;

import com.example.day06text2.bean.PeopleBean;

public interface MainCallBack {
    void onSuccess(PeopleBean resultBean );
    void onFail(String str);
}
