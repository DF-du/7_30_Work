package com.dlf.homework_two.fragment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dlf.homework_two.MainActivity;
import com.dlf.homework_two.R;
import com.dlf.homework_two.adapter.Rec_Adapter;
import com.dlf.homework_two.bean.FuliBean;
import com.dlf.homework_two.databinding.PopshowBinding;
import com.dlf.homework_two.presenter.Fuli_Presenter;
import com.dlf.homework_two.view.FuliView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements FuliView {
    private ArrayList<FuliBean.ResultsBean> resultsBeans;
    private Rec_Adapter rec_adapter;
    Context context;
    private RecyclerView mRec;
    private PopupWindow window;
    private RecyclerView rec;
    private LinearLayout ll;
    private FuliBean.ResultsBean bean;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(@NonNull final View itemView) {
        ll = itemView.findViewById(R.id.ll);
        mRec = (RecyclerView) itemView.findViewById(R.id.rec);
        mRec.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRec.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        resultsBeans = new ArrayList<>();
        rec_adapter = new Rec_Adapter(context, resultsBeans);
        mRec.setAdapter(rec_adapter);

        rec_adapter.setClick(new Rec_Adapter.Onclick() {
            @Override
            public void onClick(int i) {
                initpopwin();
            }
        });

    }

    public void initpopwin() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.popshow, null);
        window = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(null);
        window.setOutsideTouchable(true);
        window.showAtLocation(ll, Gravity.CENTER, 0, 0);
        Button id = inflate.findViewById(R.id.Button);
        id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);

                String channelId = "1";
                String channelName = "default";
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
                    channel.enableLights(true);//开启指示灯,如果设备有的话。
                    channel.setLightColor(Color.RED);//设置指示灯颜色
                    channel.setShowBadge(true);//检测是否显示角标
                    manager.createNotificationChannel(channel);
                }

                for (int i = 0; i <rec_adapter.resultsBeans.size(); i++) {
                    bean = rec_adapter.resultsBeans.get(i);
                }
                Notification build = new NotificationCompat.Builder(getContext(), channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)//设置小图
                        .setContentText(bean.getDesc())//设置内容
                        .setContentTitle("我是标题")//设置标题
                        .setDefaults(Notification.DEFAULT_ALL)//设置提示效果
                        .setAutoCancel(true)//设置点击自动消失
                        .setNumber(3)//设置角标计数
                        .build();

                manager.notify(100, build);

            }
        });
    }

    private void initData() {
        Fuli_Presenter presenter = new Fuli_Presenter(this);
        presenter.getData();
    }

    @Override
    public void onSuccess(FuliBean bean) {
        List<FuliBean.ResultsBean> results = bean.getResults();
        resultsBeans.addAll(results);
        rec_adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailed(String error) {

    }


}
