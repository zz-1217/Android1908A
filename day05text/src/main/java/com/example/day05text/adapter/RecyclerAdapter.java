package com.example.day05text.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day05text.R;
import com.example.day05text.bean.Bean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    boolean check = true;
    @BindView(R.id.Ck_Box)
    CheckBox CkBox;
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
        Glide.with(context).load(videoinfoBean.getImgsrc()).into(viewHolder.img);

        if (check == false) {
            viewHolder.Ck_Box.setVisibility(View.VISIBLE);
        } else {
            viewHolder.Ck_Box.setVisibility(View.GONE);
        }
    }



    @Override
    public int getItemCount() {
        return list.size();
    }


    public void isCheck(boolean isChecks) {
        check = isChecks;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        CheckBox Ck_Box;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            Ck_Box = itemView.findViewById(R.id.Ck_Box);

        }
    }
}
