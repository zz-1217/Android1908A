package com.example.day06text.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day06text.R;
import com.example.day06text.bean.Bean;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    private List<Bean.T1348647909107Bean> list = new ArrayList<>();


    public RecyclerAdapter(Context context) {
        this.context = context;
    }


    public void addList(List<Bean.T1348647909107Bean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.recycler, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Bean.T1348647909107Bean videoinfoBean = list.get(i);
        viewHolder.title.setText(videoinfoBean.getTitle());
        viewHolder.name.setText(videoinfoBean.getSource());
        viewHolder.time.setText(videoinfoBean.getLmodify());


    }



    @Override
    public int getItemCount() {
        return list.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView time;
        TextView name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            time = itemView.findViewById(R.id.time);
            name = itemView.findViewById(R.id.name);


        }
    }
}
