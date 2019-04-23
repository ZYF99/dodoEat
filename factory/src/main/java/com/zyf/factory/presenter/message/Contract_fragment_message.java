package com.zyf.factory.presenter.message;

import com.zyf.common.factory.presenter.base.BaseContract;
import com.zyf.factory.model.message.Message;

import java.util.List;

public interface Contract_fragment_message {
    interface View extends BaseContract.View<Presenter> {
        //刷新完成的回调
        void onRefreshDown(List<Message>list);
    }
    interface Presenter extends BaseContract.Presenter{
        //刷新列表
        void refreshList();
    }
}
