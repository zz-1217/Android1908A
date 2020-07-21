package com.example.day05text.presenter;

import com.example.day05text.api.MainCallBack;
import com.example.day05text.base.BasePresenter;
import com.example.day05text.bean.Bean;
import com.example.day05text.model.MainModel;
import com.example.day05text.view.MainView;

public  class MainPresenter extends BasePresenter<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }


    @Override
    public void onSuccess(Bean bean) {
        mView.setData(bean);
    }

    @Override
    public void onFail(String str) {
        mView.showToast(str);
    }

    public void getData(){
        mainModel.getData(this);
    }
}
