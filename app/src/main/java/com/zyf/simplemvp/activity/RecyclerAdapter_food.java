package com.zyf.simplemvp.activity;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zyf.factory.model.shop.Shop;
import com.zyf.simplemvp.R;

import java.util.List;

public class RecyclerAdapter_food extends BaseQuickAdapter<Shop.Food, BaseViewHolder> {

    public RecyclerAdapter_food(int layoutResId, @Nullable List<Shop.Food> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Shop.Food item) {
        helper.setText(R.id.cell_msg_title, item.getName());
        helper.setText(R.id.cell_msg_time,item.getCost()+"RMB");
        //食物图片加载
        Glide.with(mContext).load(item.getImgUrl()).into((ImageView) helper.getView(R.id.cell_msg_icon));
    }
}
