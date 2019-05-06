package com.zyf.factory.presenter.detail_dynamic;

import com.zyf.common.factory.presenter.base.BaseContract;

public interface Contract_dynamic {
    interface View extends BaseContract.View<Presenter> {
        //功能1接口回调
        void fun1Callback();

    }

    interface Presenter extends BaseContract.Presenter {
        //功能1
        void fun1();
    }
}
