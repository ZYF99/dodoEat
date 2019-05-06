package com.zyf.simplemvp.activity.fans;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyf.common.common.app.PresenterActivity;
import com.zyf.factory.model.fans.Fans;
import com.zyf.factory.presenter.fans.Contract_fans;
import com.zyf.factory.presenter.fans.Presenter_fans;
import com.zyf.simplemvp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class FansActivity extends PresenterActivity<Contract_fans.Presenter> implements Contract_fans.View {

    @BindView(R.id.toolbar_title)
    TextView tv_title;
    @BindView(R.id.toolbar_back)
    ImageView btn_back;
    @BindView(R.id.inner_recycler)
    RecyclerView recyclerView;

    FansRecyclerAdapter adapter;
    List<Fans>list_fans = new ArrayList<>();

    //点击返回
    @OnClick(R.id.toolbar_back)
    void OnBackClick() {
        finish();
    }

    //抛给外界的启动activity的方法
    public static void show(Context context, Intent intent) {
        context.startActivity(intent);
    }


    //得到布局ID
    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_fans;
    }

    //初始化控件
    @Override
    protected void initWidget() {
        super.initWidget();
        tv_title.setText(R.string.fans);
        adapter = new FansRecyclerAdapter(R.layout.cell_fans,list_fans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    //初始化控件后，初始化数据
    @Override
    protected void initData() {
        super.initData();
        mPresenter.refreshList();
    }

    //特有方法
    @Override
    public void onRefreshDone(List<Fans>list) {
        adapter.replaceData(list);
    }


    //初始化Presenter
    @Override
    public Contract_fans.Presenter initPresenter() {
        return new Presenter_fans(this);
    }


}
