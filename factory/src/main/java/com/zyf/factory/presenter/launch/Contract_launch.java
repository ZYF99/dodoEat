package com.zyf.factory.presenter.launch;

import com.zyf.common.factory.presenter.base.BaseContract;
import com.zyf.factory.model.User;

public interface Contract_launch {
    interface View extends BaseContract.View<Presenter> {
        //用户信息获取成功回调
        void onUserInfoDone(User user);

    }

    interface Presenter extends BaseContract.Presenter {

        //获取本用户信息
        void getUserInfo();
    }
}
