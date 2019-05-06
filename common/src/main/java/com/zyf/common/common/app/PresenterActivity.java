package com.zyf.common.common.app;

import com.zyf.common.factory.presenter.base.BaseContract;

public abstract class PresenterActivity<Presenter extends BaseContract.Presenter> extends Activity
        implements BaseContract.View<Presenter> {

    protected Presenter mPresenter;

    //抛给具体的Activity实现类去实现
    public abstract Presenter initPresenter();

    @Override
    protected void initBefore() {
        super.initBefore();
        initPresenter();
    }

    @Override
    public void showError(int str) {
        Application.showToast(str);
    }

    @Override
    public void showLoadind() {
        //TODO 显示LOADING信息
    }

    @Override
    public void setPresenter(Presenter presenter) {
        mPresenter = presenter;
    }
}
