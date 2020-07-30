package com.dlf.project.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dlf.project.R;
import com.dlf.project.bean.SqlBean;
import com.dlf.project.sql.SQLUtil;

public class SqlLiteFragment extends Fragment implements View.OnClickListener {
    private Button mInsert;
    private Button mDelete;
    private Button mQuery;
    private Button mWhereQuery;
    private EditText mQueryEt;
    private EditText mInsertEt;
    private EditText mDeleteEt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.sqllayout, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mInsert = (Button) itemView.findViewById(R.id.insert);
        mInsert.setOnClickListener(this);
        mDelete = (Button) itemView.findViewById(R.id.delete);
        mDelete.setOnClickListener(this);
        mQuery = (Button) itemView.findViewById(R.id.query);
        mQuery.setOnClickListener(this);
        mWhereQuery = (Button) itemView.findViewById(R.id.query_where);
        mWhereQuery.setOnClickListener(this);
        mQueryEt = (EditText) itemView.findViewById(R.id.et_query);
        mInsertEt = (EditText) itemView.findViewById(R.id.et_insert);
        mDeleteEt = (EditText) itemView.findViewById(R.id.et_delete);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                // TODO 20/07/30
                SQLUtil.insert("dlf","123123");
                Toast.makeText(getActivity(), "插入成功" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                // TODO 20/07/30
                SQLUtil.delete(new SqlBean());
                Toast.makeText(getActivity(), "删除成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.query:
                // TODO 20/07/30
                break;
            case R.id.query_where:
                // TODO 20/07/30
                break;
            default:
                break;
        }
    }
}
