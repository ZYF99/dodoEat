package com.zyf.simplemvp.fragment.message;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zyf.factory.model.message.Message;
import com.zyf.simplemvp.R;

import java.util.List;

    public class MessageRecyclerAdapter extends BaseQuickAdapter<Message, BaseViewHolder> {

    Listener listener;

    public MessageRecyclerAdapter(int layoutResId, @Nullable List<Message> data, MessageRecyclerAdapter.Listener listener) {
        super(layoutResId, data);
        this.listener = listener;
    }
    @Override
    protected void convert(BaseViewHolder helper, Message item) {

        Glide.with(mContext).load(item.getIconUrl()).into((ImageView) (helper.getView(R.id.cell_msg_icon)));
        helper.setText(R.id.cell_person_name,item.getTitle());
        helper.setText(R.id.cell_person_btn,item.getMsg());
        helper.setText(R.id.cell_msg_time,item.getTime());

        //单项点击事件
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                listener.onCellClick();
            }
        });
    }

    interface Listener{
        void onCellClick();
        void onCellLongClick();

    }
}
