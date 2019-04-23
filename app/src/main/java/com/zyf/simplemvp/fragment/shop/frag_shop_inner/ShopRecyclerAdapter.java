package com.zyf.simplemvp.fragment.shop.frag_shop_inner;


import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zyf.factory.model.shop.Shop;
import com.zyf.simplemvp.R;
import java.util.List;

public class ShopRecyclerAdapter extends BaseQuickAdapter<Shop, BaseViewHolder> {

    private Listener listener;

    public ShopRecyclerAdapter(int layoutResId, @Nullable List<Shop> data, Listener listener) {
        super(layoutResId, data);
        this.listener = listener;
    }

    @Override
    protected void convert(BaseViewHolder helper, Shop item) {
        //商铺的名字
        helper.setText(R.id.cell_shopname, item.getName());
        //商铺的简介
        helper.setText(R.id.cell_shopbrief, item.getBrief());

        //图片加载
        Glide.with(mContext).load(item.getIconUrl()).into((ImageView) helper.getView(R.id.cell_shopicon));
        Glide.with(mContext).load(item.getFoods().get(0).getImgUrl()).into((ImageView) helper.getView(R.id.cell_shopimg0));
        Glide.with(mContext).load(item.getFoods().get(1).getImgUrl()).into((ImageView) helper.getView(R.id.cell_shopimg1));
        Glide.with(mContext).load(item.getFoods().get(2).getImgUrl()).into((ImageView) helper.getView(R.id.cell_shopimg2));

        //子控件监听点击
        helper.addOnClickListener(R.id.btn_cell);

        //监听到的事件抛给Fragment去处理
        setOnLoadMoreListener(listener, getRecyclerView());

        setOnItemLongClickListener((adapter, view, position) -> {
            listener.onCellLongClick(position);
            return true;
        });

        //子控件点击事件
        setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.btn_cell:
                        listener.onCellClick(position);
                        break;
                    default:
                        break;
                }

            }
        });
        //子控件长按事件
        setOnItemChildLongClickListener(new OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId())
                {
                    case R.id.btn_cell:
                        listener.onCellLongClick(position);
                        break;
                }
                return true;
            }
        });
    }


    //cell的监听器
    interface Listener extends RequestLoadMoreListener {

        void onCellClick(int position);

        void onCellLongClick(int position);

        //加载回调给Fragment的接口
        @Override
        void onLoadMoreRequested();
    }

}