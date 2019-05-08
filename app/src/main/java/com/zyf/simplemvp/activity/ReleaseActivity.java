package com.zyf.simplemvp.activity;

import android.content.Context;
import android.content.Intent;

import com.zyf.common.common.app.Activity;
import com.zyf.simplemvp.R;

public class ReleaseActivity extends Activity {

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_shop;
    }

    //抛给外界的启动activity的方法
    public static void show(Context context, Intent intent) {
        context.startActivity(intent);
    }

}
