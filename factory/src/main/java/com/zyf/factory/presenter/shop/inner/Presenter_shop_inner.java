package com.zyf.factory.presenter.shop.inner;


import com.zyf.factory.data.helper.ShopHelper;
import com.zyf.factory.model.shop.RequestModel_getShopList;
import com.zyf.factory.model.shop.Shop;
import com.zyf.factory.presenter.inner.Contract_fragment_innerList;
import com.zyf.factory.presenter.inner.Presenter_fragment_innerList;

/**
 * 首页内部列表的Presenter
 * 数据类是Dynamic
 */
public class Presenter_shop_inner extends Presenter_fragment_innerList<Shop> {


    public Presenter_shop_inner(Contract_fragment_innerList.View mView, String type) {
        super(mView, type);
    }


    /**
     * 刷新更多动态列表数据的接口
     */
    @Override
    public void refreshList() {
        super.refreshList();
        //根据接受的列表数据类型（关注，发现，附近)构造请求model
        RequestModel_getShopList model_getShopList = new RequestModel_getShopList(type);
        ShopHelper.getList(model_getShopList, this);

    }

    /**
     * 拉取更多动态列表数据的接口
     */
    @Override
    public void loadMoreList() {
        super.loadMoreList();
        //构建获取动态列表的请求的请求参数
        RequestModel_getShopList model_getShopList = new RequestModel_getShopList(type);
        //调用工厂去获取动态列表
        ShopHelper.getList(model_getShopList, this);

    }


}
