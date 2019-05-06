package com.zyf.simplemvp.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.zyf.common.common.app.PresenterActivity;
import com.zyf.factory.model.shop.Shop;
import com.zyf.factory.presenter.detail_shop.Contract_DetailShop;
import com.zyf.factory.presenter.detail_shop.Presenter_DetailShop;
import com.zyf.simplemvp.R;
import butterknife.BindView;
import butterknife.OnClick;


public class Detail_ShopActivity extends PresenterActivity<Contract_DetailShop.Presenter> implements Contract_DetailShop.View {
    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.shop_bg)
    ImageView iv_bg;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.shop_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.shop_backdrop)
    ImageView backdrop;
    Shop shop;
    RecyclerAdapter_food adapter;


    //得到布局Id
    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_shop;
    }

    //抛给外界的启动activity的方法
    public static void show(Context context, Intent intent) {
        context.startActivity(intent);
    }



    //初始化控件之前
    @Override
    protected void initBefore() {
        super.initBefore();
        //接收前一活动序列化传来的动态详情对象
        shop = (Shop) getIntent().getSerializableExtra("shop_data");
    }


    //初始化控件
    @Override
    protected void initWidget() {
        super.initWidget();
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle(shop.getName());
        collapsingToolbarLayout.setContentScrimColor(Color.argb(200, 0, 0, 0));
        Glide.with(this).load(shop.getIconUrl()).into(iv_bg);
        recyclerView.setLayoutManager(new LinearLayoutManager(Detail_ShopActivity.this));
        adapter = new RecyclerAdapter_food(R.layout.cell_food, shop.getFoods());
        recyclerView.setAdapter(adapter);
    }




    //特有方法
    @Override
    public void fun1Callback() {

    }


    //返回键点击事件
    @OnClick(R.id.shop_backdrop)
    void onBackClick(){
        finish();
    }

    //初始化Presenter
    @Override
    public Contract_DetailShop.Presenter initPresenter() {
        return new Presenter_DetailShop(this);
    }
}
