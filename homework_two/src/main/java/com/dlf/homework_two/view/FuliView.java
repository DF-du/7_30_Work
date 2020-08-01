package com.dlf.homework_two.view;


import com.dlf.homework_two.bean.FuliBean;

public interface FuliView {
    void onSuccess(FuliBean bean);
    void onFailed(String error);
}
