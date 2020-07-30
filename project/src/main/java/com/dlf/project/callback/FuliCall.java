package com.dlf.project.callback;

import com.dlf.project.bean.FuliBean;

public interface FuliCall {
    void onSuccess(FuliBean bean);
    void onFailed(String error);
}
