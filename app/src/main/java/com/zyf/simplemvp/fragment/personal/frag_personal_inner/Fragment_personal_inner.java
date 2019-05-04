package com.zyf.simplemvp.fragment.personal.frag_personal_inner;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zyf.common.common.app.PresenterFragment;
import com.zyf.factory.model.homepage.Dynamic;
import com.zyf.factory.presenter.inner.Contract_fragment_innerList;
import com.zyf.factory.presenter.personal.inner.Presenter_personal_inner;
import com.zyf.factory.presenter.shop.inner.Presenter_shop_inner;
import com.zyf.simplemvp.R;
import com.zyf.simplemvp.activity.DynamicActivity;
import com.zyf.simplemvp.activity.ShopActivity;
import com.zyf.simplemvp.fragment.homepage.frag_homepage_inner.DynamicRecyclerAdapter;
import com.zyf.simplemvp.fragment.shop.frag_shop_inner.ShopRecyclerAdapter;

import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;


public class Fragment_personal_inner extends PresenterFragment<Contract_fragment_innerList.Presenter>
        implements Contract_fragment_innerList.View<Dynamic>, OnRefreshListener, PersonalDynamicRecyclerAdapter.Listener {

    String TAG = "Fragment_personal_inner";
    //本页面的类型（笔记，收藏，赞过）
    protected String type;

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @BindView(R.id.inner_recycler)
    RecyclerView recyclerView;


    //DynamicRecyclerAdapter dynamicRecyclerAdapter;
    PersonalDynamicRecyclerAdapter personalDynamicRecyclerAdapter;
    List<Dynamic> list = new ArrayList<>();

    public Fragment_personal_inner() {


    }

    public static Fragment_personal_inner newInstance(String type) {

        //放入参数
        Bundle args = new Bundle();
        args.putString("type", type);
        //根据传入type类型新建一个首页内部的Fragment然后返给首页
        Fragment_personal_inner fragment_personal_inner = new Fragment_personal_inner();
        fragment_personal_inner.setArguments(args);
        return fragment_personal_inner;
    }

    @Override
    protected void initArgs(Bundle bundle) {
        super.initArgs(bundle);
        type = bundle.getString("type");
    }

    public String getType() {
        return type;
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        //初始化recyclerview列表
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        personalDynamicRecyclerAdapter = new PersonalDynamicRecyclerAdapter(R.layout.cell_dynamic, list, this);
        personalDynamicRecyclerAdapter.bindToRecyclerView(recyclerView);
        personalDynamicRecyclerAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        refreshLayout.setOnRefreshListener(this);
    }


    /**
     * 首次加载页面之后——从服务器刷新列表
     */
    @Override
    protected void onFirstInit() {
        super.onFirstInit();
        refreshLayout.autoRefresh(0);
    }


    /**
     * 非首次加载界面的加载数据
     */
    @Override
    protected void initData() {
        super.initData();
    }

    /**
     * 得到首页内部Fragment的布局id（三个页面共用此布局）
     */
    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_inner_list;
    }


    //返回此Presenter_homepage_inner的实体类对象，并告诉它我们的列表数据类型（关注or发现or附近）
    @Override
    protected Contract_fragment_innerList.Presenter initPresenter() {
        return new Presenter_personal_inner(this, type);
    }


    //**************************************数据回调************************************************


    //从服务器刷新动态列表数据后的回调
    @Override
    public void onRefreshListDown(List<Dynamic> newList) {
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                Log.d(TAG, "刷新回调");
                personalDynamicRecyclerAdapter.replaceData(newList);
                refreshLayout.finishRefresh();
            }
        });
    }

    //从服务器加载更多动态列表数据后的回调
    @Override
    public void onLoadMoreListDown(List<Dynamic> newList) {
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                Log.d(TAG, "加载回调");
                if (newList.size() > 0) {
                    personalDynamicRecyclerAdapter.addData(newList);
                    personalDynamicRecyclerAdapter.loadMoreComplete();

                } else {
                    personalDynamicRecyclerAdapter.loadMoreEnd();
                }

            }
        });
    }


    //**********************************列表适配器提供的界面回调*************************************

    //点击了单项卡片
    @Override
    public void onCellClick(int position) {
        Intent intent = new Intent(getContext(), DynamicActivity.class);
        intent.putExtra("dynamic_data", list.get(position));
        DynamicActivity.show(Objects.requireNonNull(getContext()), intent);
    }


    //长按了单项卡片
    @Override
    public void onCellLongClick(int position) {

    }

    @Override
    public void onHeartClick(View heartView, int position) {
        list.get(position).setLike(true);
        showHeartAnim(heartView);
    }

    //爱心动画
    void showHeartAnim(View heartView) {
        Animation heart_in = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_in);
        Animation heart_out = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_out);
        heartView.startAnimation(heart_in);

        ((ImageView) heartView).setImageResource(R.drawable.ic_heart_pressed);
        heartView.startAnimation(heart_out);
    }

    //触发了上拉加载(来源Brvha)
    @Override
    public void onLoadMoreRequested() {
        Log.d(TAG, "触发加载");
        mPresenter.loadMoreList();
    }


    //触发了下拉刷新(来源SmartRefreshLayout)
    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        Log.d(TAG, "触发刷新");
        mPresenter.refreshList();
    }




}
