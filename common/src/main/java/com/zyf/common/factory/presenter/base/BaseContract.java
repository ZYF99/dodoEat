package com.zyf.common.factory.presenter.base;

import android.support.annotation.StringRes;

/**
 * MVP格式中公共基本契约
 */
public interface BaseContract {
    interface View<T extends Presenter> {

        void showError(@StringRes int str);

        void showLoadind();

        void setPresenter(T presenter);
    }

    interface Presenter {
        void start();

        void destroy();
    }
}
