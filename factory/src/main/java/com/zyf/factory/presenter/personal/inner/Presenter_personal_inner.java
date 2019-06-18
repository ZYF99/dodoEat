package com.zyf.factory.presenter.personal.inner;


import com.zyf.common.factory.data.base.DataSource;
import com.zyf.factory.data.helper.DynamicHelper;
import com.zyf.factory.model.dynamic.Dynamic;
import com.zyf.factory.model.dynamic.RequestModel_getDynamicList;
import com.zyf.factory.presenter.inner.Contract_fragment_innerList;
import com.zyf.factory.presenter.inner.Presenter_fragment_innerList;

import java.util.List;

/**
 * 首页内部列表的Presenter
 * 数据类是Dynamic
 */
public class Presenter_personal_inner extends Presenter_fragment_innerList<Dynamic> implements DataSource.Callback<List<Dynamic>> {

    private int startPage = 0;
    private int endPage = 1;

    public Presenter_personal_inner(Contract_fragment_innerList.View mView, String type) {
        super(mView, type);
    }


    /**
     * 刷新更多动态列表数据的接口
     */
    @Override
    public void refreshList() {
        super.refreshList();
        startPage = 0;
        endPage = 1;
        //根据接受的列表数据类型（关注，发现，附近)构造请求model
        RequestModel_getDynamicList model_getDynamicList = new RequestModel_getDynamicList(startPage,endPage);
        DynamicHelper.getList(model_getDynamicList, this);
    }

    /**
     * 拉取更多动态列表数据的接口
     */
    @Override
    public void loadMoreList() {
        super.loadMoreList();
        startPage ++;
        endPage ++;
        //构建获取动态列表的请求的请求参数
        RequestModel_getDynamicList model_getDynamicList = new RequestModel_getDynamicList(startPage,endPage);
        //调用工厂去获取动态列表
        DynamicHelper.getList(model_getDynamicList, this);
    }


}
