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
import com.zyf.common.common.app.Activity;
import com.zyf.factory.model.shop.Shop;
import com.zyf.simplemvp.R;
import butterknife.BindView;
import butterknife.OnClick;


public class ShopActivity extends Activity {
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

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_shop;
    }

    //抛给外界的启动activity的方法
    public static void show(Context context, Intent intent) {
        context.startActivity(intent);
    }

    @Override
    protected void initBefore() {
        super.initBefore();
        //接收前一活动序列化传来的动态详情对象
        shop = (Shop) getIntent().getSerializableExtra("shop_data");
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle(shop.getName());
        collapsingToolbarLayout.setContentScrimColor(Color.argb(200, 0, 0, 0));
        Glide.with(this).load(shop.getIconUrl()).into(iv_bg);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShopActivity.this));
        adapter = new RecyclerAdapter_food(R.layout.cell_food, shop.getFoods());
        recyclerView.setAdapter(adapter);
    }


    //返回键点击事件
    @OnClick(R.id.shop_backdrop)
    void onBackClick(){
        finish();
    }


}
