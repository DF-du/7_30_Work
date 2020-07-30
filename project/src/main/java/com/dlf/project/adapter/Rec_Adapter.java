package com.dlf.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dlf.project.R;
import com.dlf.project.bean.FuliBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Rec_Adapter extends RecyclerView.Adapter<Rec_Adapter.ViewHolder> {
    private Context context;
    private ArrayList<FuliBean.ResultsBean> resultsBeans;

    public Rec_Adapter(Context context, ArrayList<FuliBean.ResultsBean> resultsBeans) {
        this.context = context;
        this.resultsBeans = resultsBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FuliBean.ResultsBean bean = resultsBeans.get(position);
        holder.title.setText(bean.getDesc());
        Glide.with(context).load(bean.getUrl()).into(holder.url);
    }

    @Override
    public int getItemCount() {
        return resultsBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.url)
        ImageView url;
        @BindView(R.id.title)
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
