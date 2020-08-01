package com.dlf.project.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dlf.project.R;
import com.dlf.project.adapter.Rec_Adapter;
import com.dlf.project.adapter.Rec_Adapter_copy;
import com.dlf.project.bean.FuliBean;
import com.dlf.project.sql.MySQLite;

import java.util.ArrayList;
import java.util.List;

public class SqlLiteFragment extends Fragment {

    private RecyclerView mRec;
    private ArrayList<FuliBean.ResultsBean> beans;
    private Rec_Adapter_copy adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.sqllayout, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
    }

    private void initView(@NonNull final View itemView) {
        mRec = (RecyclerView) itemView.findViewById(R.id.rec);
        mRec.setLayoutManager(new LinearLayoutManager(getActivity()));
        beans = new ArrayList<>();
        adapter = new Rec_Adapter_copy(getActivity(), beans);
        mRec.setAdapter(adapter);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser == true) {
            if (beans !=null) {
                MySQLite sqLite = new MySQLite(getActivity());
                List<FuliBean.ResultsBean> list = sqLite.queryAll();
                beans.addAll(list);
                adapter.notifyDataSetChanged();
            }
        }

    }
}
