package com.dlf.homework_two.callback;


import com.dlf.homework_two.bean.FuliBean;

public interface FuliCall {
    void onSuccess(FuliBean bean);
    void onFailed(String error);
}
