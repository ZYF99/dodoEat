package com.zyf.factory.presenter.inner;

import com.zyf.common.factory.data.base.DataSource;
import com.zyf.common.factory.presenter.base.BasePresenter;

import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;

import java.util.List;


/**
 * 仅有列表的Fragment的抽象Presenter
 * 必须重写refresh 和 loadMore方法
 */

public abstract class
Presenter_fragment_innerList<T> extends BasePresenter<Contract_fragment_innerList.View> implements Contract_fragment_innerList.Presenter, DataSource.Callback<List<T>> {

    private static final String TAG = "Presenter_fragment_innerList";
    //此Fragment的列表数据类型（发现，附近，火锅，串串。。。)
    final protected String type;

    //获取列表数据的状态（是加载还是刷新）
    private static final int CHANGELIST_REFRESH = 0;
    private static final int CHANGELIST_LOADMORE = 1;
    private int type_changeList = CHANGELIST_REFRESH;

    //向View层提供的构造方法
    public Presenter_fragment_innerList(Contract_fragment_innerList.View mView, String type) {
        super(mView);
        this.type = type;
    }


    /**
     * 刷新更多,等待子类去实现功能
     */
    @Override
    public void refreshList() {

        //将现在状态置为正在更新
        type_changeList = CHANGELIST_REFRESH;


    }

    /**
     * 拉取更多,等待子类去实现功能
     */
    @Override
    public void loadMoreList() {
        //将现在状态置为正在加载
        type_changeList = CHANGELIST_LOADMORE;

    }


    //列表获取成功后的回调
    @Override
    public void onDataLoaded(List<T> list) {
        //判断是更新了数据还是加载了数据
        if (type_changeList == CHANGELIST_REFRESH) {
            mView.onRefreshListDown(list);
        } else {
            mView.onLoadMoreListDown(list);
        }
    }

    //动态列表获取失败后的回调
    @Override
    public void onDataNotAvaliable(final int strRes) {
        //网络请求告知注册失败
        final Contract_fragment_innerList.View view = getView();
        if (view == null)
            return;
        //此时是从玩过回送回来的，并不保证属于主线程状态
        //强制执行在主线程中
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                //调用主界面的注册成功
                view.showError(strRes);
            }
        });
    }
}
