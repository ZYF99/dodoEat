package com.zyf.common.common.app;

import android.content.Context;
import com.zyf.common.factory.presenter.base.BaseContract;

public abstract class PresenterFragment<Presenter extends BaseContract.Presenter> extends Fragment
implements BaseContract.View<Presenter>{

    protected Presenter mPresenter;

    //抛给具体的Fragment实现类去实现
    protected abstract Presenter initPresenter();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initPresenter();
    }

    @Override
    public void showError(int str) {
        //TODO 显示错误信息
    }

    @Override
    public void showLoadind() {
        //TODO 显示LOADING信息
    }

    @Override
    public void setPresenter(Presenter presenter) {
        //View中赋值Presenter
        mPresenter = presenter;
    }
}
