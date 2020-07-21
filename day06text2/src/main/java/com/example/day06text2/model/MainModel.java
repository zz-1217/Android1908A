package com.example.day06text2.model;

import com.example.day06text2.api.ApiService;
import com.example.day06text2.api.InCallBack;
import com.example.day06text2.api.MainCallBack;
import com.example.day06text2.base.BaseModel;
import com.example.day06text2.bean.InBean;
import com.example.day06text2.bean.PeopleBean;
import com.example.day06text2.presenter.MainPresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {

    public void getPeopleData(final MainCallBack mainCallBack) {
        new Retrofit.Builder().baseUrl(ApiService.basePeopleUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getPeopleData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PeopleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PeopleBean resultBean) {
                        mainCallBack.onSuccess(resultBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
