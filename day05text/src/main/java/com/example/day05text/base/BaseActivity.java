package com.example.day05text.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayout());
        ButterKnife.bind(this);
        initPresenter();
        if(mPresenter!=null){
            mPresenter.bindView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract int getlayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initPresenter();

    protected abstract void initListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.destroy();
            mPresenter = null;
        }
    }
}
