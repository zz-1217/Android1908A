package com.example.day06text.presenter;

import com.example.day06text.api.MainCallBack;
import com.example.day06text.base.BaseModel;
import com.example.day06text.base.BasePresenter;
import com.example.day06text.bean.Bean;
import com.example.day06text.model.MainModel;
import com.example.day06text.view.MainView;

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

    public void getBeanData(){
        mainModel.getData(this);
    }
}
