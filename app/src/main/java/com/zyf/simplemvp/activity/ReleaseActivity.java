package com.zyf.simplemvp.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zyf.common.common.app.PresenterActivity;
import com.zyf.factory.model.release.Model_release;
import com.zyf.factory.presenter.release.Contract_release;
import com.zyf.factory.presenter.release.Presenter_release;
import com.zyf.simplemvp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class ReleaseActivity extends PresenterActivity<Contract_release.Presenter> implements Contract_release.View {

    @BindView(R.id.toolbar_title)
    TextView tv_title;

    @BindView(R.id.text_num)
    TextView text_num;

    @BindView(R.id.rec_img)
    RecyclerView rec;

    //点击返回
    @OnClick(R.id.toolbar_back)
    void OnBackClick() {
        finish();
    }

    //点击发布
    @OnClick(R.id.btn_release)
    void OnReleaseClick() {
        mPresenter.release(new Model_release(01,new ArrayList<>(),"title","content","position"));
    }

    //图片列表
    List<String> pathList;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_release;
    }

    //抛给外界的启动activity的方法
    public static void show(Context context, Intent intent) {
        context.startActivity(intent);
    }


    @Override
    public Contract_release.Presenter initPresenter() {
        return new Presenter_release(this);
    }

    //初始化界面前的数据初始化
    @Override
    protected void initBefore() {
        super.initBefore();
        pathList = getIntent().getStringArrayListExtra("imgList");
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initWidget() {
        super.initWidget();
        tv_title.setText("编辑中···");
        text_num.setText("已选中（" + pathList.size() + "张)");
        ImgListAdapter imgListAdapter = new ImgListAdapter(R.layout.cell_img, pathList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ReleaseActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rec.setLayoutManager(linearLayoutManager);
        imgListAdapter.bindToRecyclerView(rec);
        imgListAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
    }


    //发布成功的回调
    @Override
    public void releaseSuccess() {

    }



    //****************************************************************************
    //****************************************************************************
    //已选图片的列表适配器
    class ImgListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public ImgListAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            //图片加载
            Glide.with(mContext).load(item).bitmapTransform(new RoundedCornersTransformation(ReleaseActivity.this, 25, 10)).skipMemoryCache(true).into((ImageView) helper.getView(R.id.my_img));
        }
    }


}
