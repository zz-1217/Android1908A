package com.example.day09text.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    public P mPresenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        bind = ButterKnife.bind(this, view);
        initPresenter();
        if(mPresenter!= null){
            mPresenter.bindView(this);
        }
        initView();
        initData();
        initListener();
        return view;
    }

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initPresenter();

    protected abstract void initListener();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
        mPresenter.destory();
        mPresenter = null;

    }
}
