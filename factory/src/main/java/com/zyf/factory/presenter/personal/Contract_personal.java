package com.zyf.factory.presenter.personal;

import com.zyf.common.factory.presenter.base.BaseContract;

/**
 * 功能1模块的契约
 */
public interface Contract_personal {
    interface View extends BaseContract.View<Presenter> {
        //功能1接口回调
        void fun1Callback();

    }

    interface Presenter extends BaseContract.Presenter {
        //功能1
        void fun1();
    }
}
