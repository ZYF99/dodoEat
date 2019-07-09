package com.zyf.factory.presenter.release;

import com.zyf.common.factory.presenter.base.BaseContract;
import com.zyf.factory.model.release.Model_release;

public interface Contract_release{

    interface Presenter extends BaseContract.Presenter{
        //发布动态
        void release(Model_release model);

    }
    interface View extends BaseContract.View<Presenter>{
        //发布成功后回调给活动
        void releaseSuccess();

    }

}
