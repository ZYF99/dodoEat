package com.zyf.simplemvp.fragment.homepage.frag_homepage_inner;


import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zyf.factory.model.homepage.Dynamic;
import com.zyf.simplemvp.R;

import java.util.List;

public class DynamicRecyclerAdapter extends BaseQuickAdapter<Dynamic, BaseViewHolder> {

    private Listener listener;

    public DynamicRecyclerAdapter(int layoutResId, @Nullable List<Dynamic> data, Listener listener) {
        super(layoutResId, data);
        this.listener = listener;
    }

    @Override
    protected void convert(BaseViewHolder helper, Dynamic item) {
        //动态的标题
        helper.setText(R.id.cell_txt, item.getTitle());
        //作者名
        helper.setText(R.id.cell_author_name, item.getAuthor().getName());
        //爱心图片加载
        Glide.with(mContext).load(item.isLike() ? R.drawable.ic_heart_pressed : R.drawable.ic_heart_nor).into((ImageView) helper.getView(R.id.ic_heart));
        //点赞数
        helper.setText(R.id.cell_likes, item.getLikes() + "");
        //封面大图
        Glide.with(mContext).load(item.getImgUrlList().get(0)).placeholder(R.drawable.bg_placeholder).crossFade().into((ImageView) helper.getView(R.id.cell_image));
        //头像加载
        Glide.with(mContext).load(item.getAuthor().getImageUrl()).into((ImageView) helper.getView(R.id.cell_author_portrait));

        //子控件监听点击
        helper.addOnClickListener(R.id.btn_cell);
        helper.addOnClickListener(R.id.btn_heart);

        //监听到的事件抛给Fragment去处理
        setOnLoadMoreListener(listener, getRecyclerView());
        //子控件点击事件
        setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.btn_heart:
                        listener.onHeartClick(((LinearLayout) view).getChildAt(0), position);
                        break;
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
    public interface Listener extends RequestLoadMoreListener {

        void onCellClick(int position);

        void onCellLongClick(int position);

        void onHeartClick(View heartView, int position);

        //加载回调给Fragment的接口
        @Override
        void onLoadMoreRequested();
    }

}