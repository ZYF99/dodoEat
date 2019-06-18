package com.zyf.simplemvp.activity.fans;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zyf.factory.model.Person;
import com.zyf.simplemvp.R;
import java.util.List;

public class FansRecyclerAdapter extends BaseQuickAdapter<Person, BaseViewHolder> {

    Listener listener;

    public FansRecyclerAdapter(int layoutResId, @Nullable List<Person> data ,Listener listener) {
        super(layoutResId, data);
        this.listener = listener;
    }

    @Override
    protected void convert(BaseViewHolder helper, Person item) {
        //设置昵称
        helper.setText(R.id.cell_person_name,item.getName());
        //设置按钮
        helper.setText(R.id.cell_person_btn,item.isFollowing()?R.string.cancleFollow:R.string.following);
        //头像加载
        Glide.with(mContext).load(item.getIconUrl()).into((ImageView) helper.getView(R.id.cell_person_icon));

        helper.addOnClickListener(R.id.cell_person_cell);

        //子控件点击事件
        setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.cell_person_cell:
                        listener.onCellClick(position);
                        break;
                    default:
                        break;
                }

            }
        });
    }

    interface Listener{
        //单项点击
        void onCellClick(int position);

    }
}
