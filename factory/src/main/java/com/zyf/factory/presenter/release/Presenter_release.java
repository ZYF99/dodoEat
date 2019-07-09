package com.zyf.factory.presenter.release;

import com.zyf.common.common.app.Application;
import com.zyf.common.factory.data.base.DataSource;
import com.zyf.common.factory.presenter.base.BasePresenter;
import com.zyf.factory.data.helper.DynamicHelper;
import com.zyf.factory.model.release.Model_release;

public class Presenter_release extends BasePresenter<Contract_release.View> implements DataSource.Callback<String>,Contract_release.Presenter {


    public Presenter_release(Contract_release.View mView) {
        super(mView);
    }


    //发布任务
    @Override
    public void release(Model_release model) {
        DynamicHelper.release(model,this);
        Application.showToast("正在发布");
    }

    //发布成功回调
    @Override
    public void onDataLoaded(String s) {
        mView.releaseSuccess();
        Application.showToast("发布成功"+s);
    }

    //发布失败回调
    @Override
    public void onDataNotAvaliable(int strRes) {
        Application.showToast("发布失败"+strRes);
    }
}
