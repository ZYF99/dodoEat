package com.zyf.simplemvp.fragment.shop.frag_shop_inner;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zyf.common.common.app.PresenterFragment;
import com.zyf.factory.model.shop.Shop;
import com.zyf.factory.presenter.inner.Contract_fragment_innerList;
import com.zyf.factory.presenter.shop.inner.Presenter_shop_inner;
import com.zyf.simplemvp.R;
import com.zyf.simplemvp.activity.ShopActivity;
import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import butterknife.BindView;


public class Fragment_shop_inner extends PresenterFragment<Contract_fragment_innerList.Presenter>
        implements Contract_fragment_innerList.View<Shop>, ShopRecyclerAdapter.Listener, OnRefreshListener {

    String TAG = "Fragment_homepage_inner";
    //本页面的类型（火锅，串串。。。。。）
    protected String type;


    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;


    @BindView(R.id.inner_recycler)
    RecyclerView recyclerView;


    ShopRecyclerAdapter shopRecyclerAdapter;
    List<Shop> list = new ArrayList<>();

    public Fragment_shop_inner() {


    }

    public static Fragment_shop_inner newInstance(String type) {

        //放入参数
        Bundle args = new Bundle();
        args.putString("type", type);
        //根据传入type类型新建一个首页内部的Fragment然后返给首页
        Fragment_shop_inner fragment_shop_inner = new Fragment_shop_inner();
        fragment_shop_inner.setArguments(args);
        //fragment_shop_inner.type = type;
        return fragment_shop_inner;
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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        shopRecyclerAdapter = new ShopRecyclerAdapter(R.layout.cell_shop_inner, list, this);
        shopRecyclerAdapter.bindToRecyclerView(recyclerView);
        shopRecyclerAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
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
        return new Presenter_shop_inner(this, type);
    }


    //**************************************数据回调************************************************


    //从服务器刷新动态列表数据后的回调
    @Override
    public void onRefreshListDown(List<Shop> newList) {
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                Log.d(TAG, "刷新回调");
                shopRecyclerAdapter.replaceData(newList);
                refreshLayout.finishRefresh();
            }
        });
    }

    //从服务器加载更多动态列表数据后的回调
    @Override
    public void onLoadMoreListDown(List<Shop> newList) {
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                Log.d(TAG, "加载回调");
                if (newList.size() > 0) {
                    shopRecyclerAdapter.addData(newList);
                    shopRecyclerAdapter.loadMoreComplete();

                } else {
                    shopRecyclerAdapter.loadMoreEnd();
                }

            }
        });
    }


    //**********************************列表适配器提供的界面回调*************************************

    //点击了单项卡片
    @Override
    public void onCellClick(int position) {
        Intent intent = new Intent(getContext(), ShopActivity.class);
        intent.putExtra("shop_data", list.get(position));
        ShopActivity.show(Objects.requireNonNull(getContext()), intent);
        //DynamicActivity.show(Objects.requireNonNull(getContext()), intent);
    }

    //长按了单项卡片
    @Override
    public void onCellLongClick(int position) {

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
