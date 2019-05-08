package com.zyf.factory.presenter.following;

import com.zyf.common.factory.data.base.DataSource;
import com.zyf.common.factory.presenter.base.BasePresenter;
import com.zyf.factory.R;
import com.zyf.factory.data.helper.PersonHelper;
import com.zyf.factory.model.Person;
import com.zyf.factory.model.fans.RequestModel_getFansList;
import com.zyf.factory.model.following.RequestModel_getFollowingList;

import java.util.List;

public class Presenter_following extends BasePresenter<Contract_following.View> implements Contract_following.Presenter, DataSource.Callback<List<Person>> {

    public Presenter_following(Contract_following.View mView) {
        super(mView);
    }


    //刷新粉丝列表
    @Override
    public void refreshList() {
        PersonHelper.getFollowingList(new RequestModel_getFollowingList(1),this);
    }

    //列表数据获取成功的回调
    @Override
    public void onDataLoaded(List<Person> fans) {
        mView.onRefreshDone(fans);
    }

    //列表数据获取失败的回调
    @Override
    public void onDataNotAvaliable(int strRes) {
        mView.showError(R.string.data_rsp_error_unknown);
    }
}
