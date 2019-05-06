package com.zyf.simplemvp.activity.fans;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zyf.factory.model.fans.Fans;
import com.zyf.simplemvp.R;
import java.util.List;

public class FansRecyclerAdapter extends BaseQuickAdapter<Fans, BaseViewHolder> {

    public FansRecyclerAdapter(int layoutResId, @Nullable List<Fans> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Fans item) {
        //设置昵称
        helper.setText(R.id.cell_fans_name,item.getName());
        //设置按钮
        helper.setText(R.id.cell_fans_btn,item.isFollowing()?R.string.cancleFollow:R.string.following);
        //爱心图片加载
        Glide.with(mContext).load(item.getIconUrl()).into((ImageView) helper.getView(R.id.cell_fans_icon));
    }
}
