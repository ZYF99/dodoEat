package com.zyf.common.factory.presenter.base;

import com.zyf.common.factory.presenter.base.BaseContract;

/**
 * 基类Presenter
 */
public class BasePresenter<T extends BaseContract.View>
        implements BaseContract.Presenter {

    protected T mView;


    //设置一个View，子类可以复写
    public BasePresenter(T mView) {
        setView(mView);
    }

    protected void setView(T view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    //给子类的使用的获取View的方法
    protected final T getView(){
        return mView;
    }

    @Override
    public void start() {
        T view = mView;
        if(view!=null){
            view.showLoadind();
        }
    }

    @Override
    public void destroy() {
        T view = mView;
        mView = null;
        if(view!=null){
            //把Presenter设置为NULL
            view.setPresenter(null);
        }
    }
}
