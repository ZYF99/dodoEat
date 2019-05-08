package com.zyf.common.common.app;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyf.common.common.widget.PlaceHolderView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 封装带懒加载的Fragment
 */
public abstract class Fragment extends android.support.v4.app.Fragment {
    protected View mRoot;
    protected Unbinder mRootUnbinder;
    protected PlaceHolderView mPlaceHolderView;
    //是否以及初始化界面控件
    private boolean isInitView = false;
    //界面是否已经可见
    private boolean isVisible = false;

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
            isInitView = true;
            isCanLoadData();
        } else {
            if (mRoot.getParent() != null) {
                //把当前root从其父控件中移除
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }
        return mRoot;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见，获取该标志记录下来
        if (isVisibleToUser) {
            Log.d("AAAAA", "该Fragment可见了");
            isVisible = true;
            isCanLoadData();
        } else {
            isVisible = false;
        }
    }


    private void isCanLoadData() {
        //所以条件是view初始化完成并且对用户可见
        if (isInitView && isVisible) {
            Log.d("AAAAA", "该Fragment加载数据了");
            lazyLoad();
            //防止重复加载数据
            isInitView = false;
            isVisible = false;
        }
    }

    private void lazyLoad() {
        if (mIsFirstInitData) {
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
        mRootUnbinder = ButterKnife.bind(this, root);
    }

    //初始化数据
    protected void initData() {

    }

    /**
     * 当首次初始化数据的时候会调用的方法
     */
    protected void onFirstInit() {

    }

    /**
     * 返回案件触发时调用
     * 返回true代表我已处理返回逻辑，ACTIVITY不用finish
     * 返回false代表我没处理逻辑，Activity走自己的逻辑
     */
    public boolean onBackPressed() {
        return false;
    }

    /**
     * 设置占位布局
     *
     * @param placeHolderView 实现了占位布局规范的View
     */
    public void setmPlaceHolderView(PlaceHolderView placeHolderView) {
        this.mPlaceHolderView = placeHolderView;
    }

}