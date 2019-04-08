package com.zyf.common.factory.data.base;

import android.support.annotation.StringRes;

/**
 * 数据源接口定义
 */

public interface DataSource {

    /**
     * 成功与失败组成的接口
     */
    interface Callback<T> extends SucceedCallback<T>,FailedCallback<T> {
    }

    /**
     * 仅成功的接口
     */
    interface SucceedCallback<T> {

        //数据加载成功回调
        void onDataLoaded(T t);
    }

    /**
     * 仅失败的接口
     */
    interface FailedCallback<T> {

        //数据加载失败的接口，网络请求失败
        void onDataNotAvaliable(@StringRes int strRes);

    }
}
