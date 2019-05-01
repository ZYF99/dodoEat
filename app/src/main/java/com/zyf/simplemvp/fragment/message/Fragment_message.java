package com.zyf.simplemvp.fragment.message;


import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zyf.common.common.app.PresenterFragment;
import com.zyf.factory.model.message.Message;
import com.zyf.factory.presenter.message.Contract_fragment_message;
import com.zyf.factory.presenter.message.Presenter_message;
import com.zyf.simplemvp.R;
import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.zyf.simplemvp.R2.id.msghead_btn1;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_message extends PresenterFragment<Contract_fragment_message.Presenter>  implements MessageRecyclerAdapter.Listener, Contract_fragment_message.View {
    @BindView(R.id.rec_msg)
    RecyclerView recyclerView;

    View headerView;
    LinearLayout btn_likeorcollect;
    LinearLayout btn_follow;
    LinearLayout btn_comment;


    MessageRecyclerAdapter adapter;

    List<Message>list = new ArrayList<>();


    public Fragment_message() {
        // Required empty public constructor
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_message;
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
        adapter = new MessageRecyclerAdapter(R.layout.cell_msg, list, this);
        adapter.bindToRecyclerView(recyclerView);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mPresenter.refreshList();
        headerView = LayoutInflater.from(getActivity()).inflate(R.layout.message_header, null);
        btn_likeorcollect = headerView.findViewById(R.id.msghead_btn1);
        btn_follow = headerView.findViewById(R.id.msghead_btn2);
        btn_comment = headerView.findViewById(R.id.msghead_btn3);
        adapter.addHeaderView(headerView);

    }




    @Override
    public void onCellClick() {

    }

    @Override
    public void onCellLongClick() {

    }

    //刷新完成回调
    @Override
    public void onRefreshDown(List<Message>list) {
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                adapter.replaceData(list);
            }
        });
    }

    @Override
    protected Contract_fragment_message.Presenter initPresenter() {
        return new Presenter_message(this);
    }
}
