package com.zyf.factory.presenter.fans;

import com.zyf.common.factory.data.base.DataSource;
import com.zyf.common.factory.presenter.base.BasePresenter;
import com.zyf.factory.R;
import com.zyf.factory.data.helper.FansHelper;
import com.zyf.factory.model.fans.Fans;
import com.zyf.factory.model.fans.RequestModel_getFansList;

import java.util.List;

public class Presenter_fans extends BasePresenter<Contract_fans.View> implements Contract_fans.Presenter, DataSource.Callback<List<Fans>> {

    public Presenter_fans(Contract_fans.View mView) {
        super(mView);
    }


    //刷新粉丝列表
    @Override
    public void refreshList() {
        FansHelper.getList(new RequestModel_getFansList(1),this);
    }


    @Override
    public void onDataLoaded(List<Fans> fans) {
        mView.onRefreshDone(fans);
    }

    @Override
    public void onDataNotAvaliable(int strRes) {
        mView.showError(R.string.data_rsp_error_unknown);
    }
}
