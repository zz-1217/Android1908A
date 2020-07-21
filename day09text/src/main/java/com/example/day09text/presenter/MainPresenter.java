package com.example.day09text.presenter;

import com.example.day09text.api.MainCallBack;
import com.example.day09text.base.BasePresenter;
import com.example.day09text.bean.Bean;
import com.example.day09text.model.MainModel;
import com.example.day09text.view.MainView;

public class MainPresenter extends BasePresenter<MainView> implements MainCallBack {

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

    public void getBeanData(){
        mainModel.getData(this);
    }
}
