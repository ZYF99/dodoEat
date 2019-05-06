package com.zyf.factory.presenter.fans;

import com.zyf.common.factory.presenter.base.BaseContract;
import com.zyf.factory.model.fans.Fans;

import java.util.List;

public interface Contract_fans {
    interface View extends BaseContract.View<Presenter> {
        //功能1接口回调
        void onRefreshDone(List<Fans>list);

    }

    interface Presenter extends BaseContract.Presenter {

        //刷新粉丝列表
        void refreshList();
    }
}
