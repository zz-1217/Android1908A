package com.example.day06text2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day06text2.R;
import com.example.day06text2.bean.PeopleBean;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public Context context;
    public List<PeopleBean.BodyBean.ResultBean> list = new ArrayList<>();

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    public void addList(List<PeopleBean.BodyBean.ResultBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        PeopleBean.BodyBean.ResultBean resultBean = list.get(i);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(context).load(resultBean.getTeacherPic()).apply(requestOptions).into(viewHolder.img);
        viewHolder.name.setText(resultBean.getTeacherName());
        viewHolder.introduce.setText(resultBean.getTitle());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(iclickListener!=null){
                    iclickListener.iclickItem(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView introduce;
        Button ok;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            introduce = itemView.findViewById(R.id.introduce);
            ok = itemView.findViewById(R.id.ok);
        }
    }
    IclickListener iclickListener;

    public void setIclickListener(IclickListener iclickListener) {
        this.iclickListener = iclickListener;
    }

    public interface IclickListener{
        void iclickItem(int i);
    }


}
