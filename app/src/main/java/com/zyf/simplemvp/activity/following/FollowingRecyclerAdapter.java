package com.zyf.simplemvp.activity.following;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zyf.factory.model.Person;
import com.zyf.simplemvp.R;

import java.util.List;

public class FollowingRecyclerAdapter extends BaseQuickAdapter<Person, BaseViewHolder> {

    public FollowingRecyclerAdapter(int layoutResId, @Nullable List<Person> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Person item) {
        //设置昵称
        helper.setText(R.id.cell_person_name,item.getName());
        //设置按钮
        helper.setText(R.id.cell_person_btn,R.string.followed);
        //头像加载
        Glide.with(mContext).load(item.getIconUrl()).into((ImageView) helper.getView(R.id.cell_person_icon));
    }
}
