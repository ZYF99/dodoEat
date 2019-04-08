package com.zyf.common.common.app;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class Fragment extends android.support.v4.app.Fragment {
    protected View mRoot;
    protected Unbinder mRootUnbinder;
    //是否第一次初始化数据
    protected boolean mIsFirstInitData = true;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //初始化参数
        initArgs(getArguments());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRoot == null) {
            int layId = getContentLayoutId();
            //初始化当前根布局，但是不在创建时就添加到container里边
            View root = inflater.inflate(layId, container, false);
            initWidget(root);
            mRoot = root;
        } else {
            if (mRoot.getParent() != null) {
                //把当前root从其父控件中移除
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }
        return mRoot;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mIsFirstInitData){
            //触发一次后就不会触发
            mIsFirstInitData = false;
            //触发
            onFirstInit();
        }

        //当View创建完成后初始化数据
        initData();
    }

    /*初始化相关参数 参数bundle
        参数正确返回true
       错误返回false*/
    protected void initArgs(Bundle bundle) {

    }

    //得到当前资源文件Id
    protected abstract int getContentLayoutId();

    //初始化控件
    protected void initWidget(View root) {
        mRootUnbinder = ButterKnife.bind(this,root);
    }

    //初始化数据
    protected void initData() {

    }

    /**
     * 当首次初始化数据的时候会调用的方法
     */
    protected void onFirstInit() {

    }

    /*返回案件触发时调用
     * 返回true代表我已处理返回逻辑，ACTIVITY不用finish
     * 返回false代表我没处理逻辑，Activity走自己的逻辑
     * */
    public boolean onBackPressed() {
        return false;
    }

}