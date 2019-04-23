package com.zyf.factory.presenter.inner;

import com.zyf.common.factory.presenter.base.BaseContract;
import com.zyf.factory.model.homepage.Dynamic;

import java.util.List;

/**
 * 仅有列表的Fragment的契约
 */
public interface Contract_fragment_innerList {
    interface View<T> extends BaseContract.View<Presenter> {
        //功能1接口回调
        void onRefreshListDown(List<T>list);
        void onLoadMoreListDown(List<T>list);
    }

    interface Presenter extends BaseContract.Presenter {
        //刷新列表
        void refreshList();
        //加载列表
        void loadMoreList();
    }
}
