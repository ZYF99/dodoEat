package com.zyf.simplemvp.fragment.message;


import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_message extends PresenterFragment<Contract_fragment_message.Presenter>  implements MessageRecyclerAdapter.Listener, Contract_fragment_message.View {
    @BindView(R.id.rec_msg)
    RecyclerView recyclerView;

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
