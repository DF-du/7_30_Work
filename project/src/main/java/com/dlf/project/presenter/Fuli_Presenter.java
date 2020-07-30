package com.dlf.project.presenter;

import com.dlf.project.bean.FuliBean;
import com.dlf.project.callback.FuliCall;
import com.dlf.project.model.Fuli_Model;
import com.dlf.project.view.FuliView;

public class Fuli_Presenter implements FuliPresenter {
    private final Fuli_Model fuli_model;
    FuliView view;

    public Fuli_Presenter(FuliView view) {
        this.view = view;
        fuli_model = new Fuli_Model();
    }

    @Override
    public void getData() {
        fuli_model.setData(new FuliCall() {
            @Override
            public void onSuccess(FuliBean bean) {
                view.onSuccess(bean);
            }

            @Override
            public void onFailed(String error) {
                view.onFailed(error);
            }
        });
    }
}
