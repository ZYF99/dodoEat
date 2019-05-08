package com.zyf.factory.presenter.launch;

import com.zyf.common.factory.data.base.DataSource;
import com.zyf.common.factory.presenter.base.BasePresenter;
import com.zyf.factory.R;
import com.zyf.factory.data.helper.UserHelper;
import com.zyf.factory.model.User;
import com.zyf.factory.model.launch.RequestModel_getUserInfo;

public class Presenter_launch extends BasePresenter<Contract_launch.View> implements Contract_launch.Presenter, DataSource.Callback<User> {

    public Presenter_launch(Contract_launch.View mView) {
        super(mView);
    }


    //刷新粉丝列表
    @Override
    public void getUserInfo() {
        UserHelper.getUserInfo(new RequestModel_getUserInfo(1), this);
    }

    //用户个人信息获取成功的回调
    @Override
    public void onDataLoaded(User user) {
        mView.onUserInfoDone(user);
    }

    //用户个人信息获取失败的回调
    @Override
    public void onDataNotAvaliable(int strRes) {
        mView.showError(R.string.data_rsp_error_unknown);
    }
}
