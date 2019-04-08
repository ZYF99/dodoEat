package com.zyf.common.common.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;
import butterknife.ButterKnife;

public abstract class Activity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化内部界面
        initWindows();
    }

    protected void initWindows() {
        if (initArgs(getIntent().getExtras())) {
            //得到界面ID并设置到界面中
            int layId = getContentLayoutId();
            setContentView(layId);
            initBefore();
            initWidget();
            initData();
        } else {
            finish();
        }
    }


    //初始化控件调用之前

    protected void initBefore() {

    }

    //初始化控件
    protected void initWidget() {
        Log.d("AAAAAA", "initWidget: ");
        ButterKnife.bind(this);
    }

    //初始化数据
    protected void initData() {

    }

    //得到当前界面布局ID
    protected abstract int getContentLayoutId();

    /*初始化相关参数 参数bundle
    参数正确返回true
    错误返回false*/
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    @Override
    public void onBackPressed() {
        //得到当前activity下的所有Fragment
        List<Fragment>fragments = getSupportFragmentManager().getFragments();
        //判断是否为空
        if(fragments!=null&&fragments.size()>0){
            for (Fragment fragment : fragments){
                //判断是否为我们能处理的fragment类型
                if(fragment instanceof com.zyf.common.common.app.Fragment){
                    //判断是否拦截了返回按钮事件
                    if(((com.zyf.common.common.app.Fragment) fragment).onBackPressed()){
                        //如果被Fragment处理了就直接return
                        return;
                    }
                }
            }
        }
        //没有Fragment，没有处理 就结束活动
        super.onBackPressed();
        finish();
    }
}
