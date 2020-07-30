package com.dlf.project.view;

import com.dlf.project.bean.FuliBean;

public interface FuliView {
    void onSuccess(FuliBean bean);
    void onFailed(String error);
}
