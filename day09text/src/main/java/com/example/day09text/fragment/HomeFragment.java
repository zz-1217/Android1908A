package com.example.day09text.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day09text.DownLoadActivity;
import com.example.day09text.R;
import com.example.day09text.adapter.RecyclerAdapter;
import com.example.day09text.base.BaseFragment;
import com.example.day09text.bean.Bean;
import com.example.day09text.presenter.MainPresenter;
import com.example.day09text.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<MainPresenter> implements MainView {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private RecyclerAdapter adapter;


//    public HomeFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
//    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        adapter = new RecyclerAdapter(getActivity());
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void initData() {
        mPresenter.getBeanData();
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MainPresenter();
    }

    @Override
    protected void initListener() {
        adapter.setIclickItenListener(new RecyclerAdapter.IclickItenListener() {
            @Override
            public void iclicItem(int i) {
                Intent intent = new Intent(getActivity(), DownLoadActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setData(Bean bean) {
        adapter.addList(bean.getData().getDatas());
    }

    @Override
    public void showToast(String str) {

    }

}
