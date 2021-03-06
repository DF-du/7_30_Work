package com.dlf.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dlf.project.R;
import com.dlf.project.bean.FuliBean;
import com.dlf.project.sql.MySQLite;

import java.util.ArrayList;
import java.util.List;

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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FuliBean.ResultsBean bean1 = resultsBeans.get(position);
                MySQLite sqLite = new MySQLite(context);
                List<FuliBean.ResultsBean> list = sqLite.queryAll();
                List<String> ids = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    ids.add(list.get(i).get_id());
                }
                if (ids.contains(bean1.get_id())){
                    Toast.makeText(context, "插入失败，已存在", Toast.LENGTH_SHORT).show();
                }else {
                    sqLite.inserts(bean1);
                    Toast.makeText(context, "插入成功", Toast.LENGTH_SHORT).show();
                }
                // 逐个进行判断 会不断吐司 进行比较
              /*  for (int i = 0; i < list.size(); i++) {
                     if (list.get(i).get_id().equals(bean1.get_id())){
                         Toast.makeText(context, "插入失败，已存在", Toast.LENGTH_SHORT).show();
                    }else {
                         sqLite.inserts(bean1);
                         Toast.makeText(context, "插入成功", Toast.LENGTH_SHORT).show();
                     }
                }*/
            }
        });
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
