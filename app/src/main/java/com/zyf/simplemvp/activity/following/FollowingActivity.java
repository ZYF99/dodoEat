package com.zyf.simplemvp.activity.following;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.zyf.common.common.app.PresenterActivity;
import com.zyf.factory.model.Person;
import com.zyf.factory.presenter.fans.Contract_fans;
import com.zyf.factory.presenter.fans.Presenter_fans;
import com.zyf.simplemvp.R;
import com.zyf.simplemvp.activity.person.PersonActivity;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

public class FollowingActivity extends PresenterActivity<Contract_fans.Presenter> implements Contract_fans.View, FollowingRecyclerAdapter.Listener {

    @BindView(R.id.toolbar_title)
    TextView tv_title;
    @BindView(R.id.toolbar_back)
    ImageView btn_back;
    @BindView(R.id.inner_recycler)
    RecyclerView recyclerView;

    FollowingRecyclerAdapter adapter;
    List<Person>list_following = new ArrayList<>();

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
        return R.layout.activity_fansorfollowing;
    }

    //初始化控件
    @Override
    protected void initWidget() {
        super.initWidget();
        tv_title.setText(R.string.myFollowing);
        adapter = new FollowingRecyclerAdapter(R.layout.cell_person,list_following,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    //初始化控件后，初始化数据
    @Override
    protected void initData() {
        super.initData();
        mPresenter.refreshList();
    }

    //关注列表获取成功回调
    @Override
    public void onRefreshDone(List<Person>list) {
        adapter.replaceData(list);
    }


    //初始化Presenter
    @Override
    public Contract_fans.Presenter initPresenter() {
        return new Presenter_fans(this);
    }


    //适配器传来的Item事件
    @Override
    public void onCellClick(int position) {
        Person person = list_following.get(position);
        PersonActivity.show(this);
    }
}
