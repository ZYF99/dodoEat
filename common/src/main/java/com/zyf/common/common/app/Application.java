package com.zyf.common.common.app;

import android.support.annotation.StringRes;
import android.widget.Toast;
import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;

public class Application extends android.app.Application {
    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    //向外部类提供访问此Application单例的全局方法
    public static Application getInstance() {
        return instance;
    }

    /**
     * 显示一个Toast
     *
     * @param msg 字符串
     */
    public static void showToast(final String msg) {
        // Toast 只能在主线程中显示，所以需要进行线程转换，
        // 保证一定是在主线程进行的show操作
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                // 这里进行回调的时候一定就是主线程状态了
                Toast.makeText(instance, msg, Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 显示一个Toast
     *
     * @param msgId 传递的是字符串的资源
     */
    public static void showToast(@StringRes int msgId) {
        showToast(instance.getString(msgId));
    }


}
