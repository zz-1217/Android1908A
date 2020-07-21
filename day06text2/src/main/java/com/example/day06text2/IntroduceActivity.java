package com.example.day06text2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day06text2.adapter.FragmentAdapter;
import com.example.day06text2.api.ApiService;
import com.example.day06text2.bean.InBean;
import com.example.day06text2.bean.PeopleBean;
import com.example.day06text2.fragment.BlackFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class IntroduceActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.introduce)
    TextView introduce;
    @BindView(R.id.ok)
    Button ok;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private PeopleBean.BodyBean.ResultBean resultBean;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        resultBean = (PeopleBean.BodyBean.ResultBean) getIntent().getSerializableExtra("bean");
        toolbar.setTitle("名师");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(this).load(resultBean.getTeacherPic()).apply(requestOptions).into(img);
        name.setText(resultBean.getTeacherName());
        introduce.setText(resultBean.getTitle());

        //tab.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiService.baseInUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Observable<InBean> observable = apiService.getInData(resultBean.getID());

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InBean inBean) {
                        fragments = new ArrayList<>();
                        List<InBean.BodyBean.ResultBean> result = inBean.getBody().getResult();
                        for (int i = 0; i < result.size(); i++) {
                            BlackFragment blackFragment = new BlackFragment();
                            fragments.add(blackFragment);
                        }
                        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
                        viewpager.setAdapter(fragmentAdapter);
                        tab.setupWithViewPager(viewpager);
                        for (int i = 0; i < result.size(); i++) {
                            tab.getTabAt(i).setText(result.get(i).getDescription());
                        }
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
