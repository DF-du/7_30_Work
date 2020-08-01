package com.dlf.project.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dlf.project.R;
import com.dlf.project.adapter.Rec_Adapter;
import com.dlf.project.bean.FuliBean;
import com.dlf.project.presenter.Fuli_Presenter;
import com.dlf.project.view.FuliView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements FuliView {
    private ArrayList<FuliBean.ResultsBean> resultsBeans;
    private Rec_Adapter rec_adapter;
    Context context;
    private RecyclerView mRec;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();
        View view = inflater.inflate(R.layout.homelayout, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(@NonNull final View itemView) {
        mRec = (RecyclerView) itemView.findViewById(R.id.rec);
        mRec.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRec.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        resultsBeans = new ArrayList<>();
        rec_adapter = new Rec_Adapter(context, resultsBeans);
        mRec.setAdapter(rec_adapter);
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
