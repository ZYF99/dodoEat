package com.zyf.factory.presenter.person;

import com.zyf.common.factory.presenter.base.BasePresenter;
import com.zyf.factory.presenter.personal.Contract_personal;

public class Presenter_person extends BasePresenter<Contract_person.View> implements Contract_person.Presenter {
    public Presenter_person(Contract_person.View mView) {
        super(mView);
    }

    @Override
    public void fun1() {

    }
}
