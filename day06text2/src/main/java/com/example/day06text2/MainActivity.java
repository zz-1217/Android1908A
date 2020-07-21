package com.example.day06text2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.day06text2.adapter.RecyclerAdapter;
import com.example.day06text2.base.BaseActivity;
import com.example.day06text2.bean.PeopleBean;
import com.example.day06text2.presenter.MainPresenter;
import com.example.day06text2.view.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private RecyclerAdapter adapter;
    private List<PeopleBean.BodyBean.ResultBean> result;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new RecyclerAdapter(this);
        recycler.setAdapter(adapter);

        toolbar.setTitle("名师推荐");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void initData() {
        mPresenter.getPeopleData();
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MainPresenter();
    }

    @Override
    protected void initListener() {
        adapter.setIclickListener(new RecyclerAdapter.IclickListener() {
            @Override
            public void iclickItem(int i) {
                PeopleBean.BodyBean.ResultBean resultBean = result.get(i);
                Intent intent = new Intent(MainActivity.this,IntroduceActivity.class);
                intent.putExtra("bean",resultBean);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setData(PeopleBean resultBean) {
        result = resultBean.getBody().getResult();

        adapter.addList(result);
    }

    @Override
    public void showToast(String str) {

    }

}
