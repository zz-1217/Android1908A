package com.example.day06text2.presenter;

import com.example.day06text2.api.MainCallBack;
import com.example.day06text2.base.BasePresenter;
import com.example.day06text2.bean.PeopleBean;
import com.example.day06text2.model.MainModel;
import com.example.day06text2.view.MainView;

public  class MainPresenter extends BasePresenter<MainView> implements MainCallBack{

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    @Override
    public void onSuccess(PeopleBean resultBean) {
        mView.setData(resultBean);
    }

    @Override
    public void onFail(String str) {
        mView.showToast(str);
    }

    public void getPeopleData() {
        mainModel.getPeopleData(this);
    }

}
