package com.example.day05text;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.day05text.adapter.RecyclerAdapter;
import com.example.day05text.base.BaseActivity;
import com.example.day05text.bean.Bean;
import com.example.day05text.presenter.MainPresenter;
import com.example.day05text.view.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.one)
    Button one;
    @BindView(R.id.two)
    Button two;
    @BindView(R.id.there)
    Button there;

    private RecyclerAdapter adapter;
    private List<Bean.T1348647909107Bean> beanList;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    protected int getlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this);
        recycler.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MainPresenter();
    }

    @Override
    protected void initListener() {

    }


    @Override
    public void showToast(String str) {

    }

    @Override
    public void setData(Bean bean) {
        beanList = bean.getT1348647909107();
        adapter.addList(beanList);
    }



    boolean isChecks;
    @OnClick({R.id.one, R.id.two, R.id.there})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                adapter.isCheck(isChecks);
                break;
            case R.id.two:
                clean();
                break;
            case R.id.there:
                adapter.isCheck(true);
                break;
        }
    }

    private void clean() {

    }
}
