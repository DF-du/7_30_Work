package com.dlf.homework_two.presenter;

import com.dlf.homework_two.bean.FuliBean;
import com.dlf.homework_two.callback.FuliCall;
import com.dlf.homework_two.model.Fuli_Model;
import com.dlf.homework_two.view.FuliView;

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
