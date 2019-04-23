package com.zyf.factory.presenter.message;

import com.zyf.common.factory.data.base.DataSource;
import com.zyf.common.factory.presenter.base.BasePresenter;
import com.zyf.factory.data.helper.MessageHelper;
import com.zyf.factory.model.message.Message;
import com.zyf.factory.model.message.RequestModel_getMessageList;

import java.util.List;

public class Presenter_message extends BasePresenter<Contract_fragment_message.View> implements Contract_fragment_message.Presenter, DataSource.Callback<List<Message>> {


    public Presenter_message(Contract_fragment_message.View mView) {
        super(mView);
    }


    @Override
    public void refreshList() {
        RequestModel_getMessageList model_getMessageList = new RequestModel_getMessageList();
        MessageHelper.getList(model_getMessageList,this);
    }

    //列表数据返回成功
    @Override
    public void onDataLoaded(List<Message> messages) {
        mView.onRefreshDown(messages);
    }


    //列表数据返回失败
    @Override
    public void onDataNotAvaliable(int strRes) {
        mView.showError(strRes);
    }
}
