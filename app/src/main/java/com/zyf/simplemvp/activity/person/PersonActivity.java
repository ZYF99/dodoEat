package com.zyf.simplemvp.activity.person;

import android.content.Context;
import android.content.Intent;
import com.zyf.common.common.app.PresenterActivity;
import com.zyf.factory.presenter.person.Contract_person;
import com.zyf.factory.presenter.person.Presenter_person;
import com.zyf.simplemvp.R;

public class PersonActivity extends PresenterActivity<Contract_person.Presenter> implements Contract_person.View {


    //MainActivity显示的入口
    public static void show(Context context) {
        context.startActivity(new Intent(context, PersonActivity.class));
    }

    //得到布局ID
    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_person;
    }

    //初始化Presenter
    @Override
    public Contract_person.Presenter initPresenter() {
        return new Presenter_person(this);
    }

    //特有回调
    @Override
    public void fun1Callback() {

    }
}
