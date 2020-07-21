package com.example.day09text.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day09text.R;
import com.example.day09text.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<Bean.DataBean.DatasBean> list = new ArrayList<>();

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    public void addList(List<Bean.DataBean.DatasBean> list){
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
        Bean.DataBean.DatasBean tagsBean = list.get(i);
        viewHolder.title.setText(tagsBean.getTitle());
        Glide.with(context).load(tagsBean.getEnvelopePic()).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iclickItenListener!= null){
                    iclickItenListener.iclicItem(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img ;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
    IclickItenListener iclickItenListener;

    public void setIclickItenListener(IclickItenListener iclickItenListener) {
        this.iclickItenListener = iclickItenListener;
    }

    public interface IclickItenListener{
        void iclicItem(int i);
    }
}
