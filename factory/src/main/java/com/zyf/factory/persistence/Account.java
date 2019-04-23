package com.zyf.factory.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;



public class Account {


    private static final String KEY_TOKEN = " KEY_TOKEN";

    private static final String KEY_USER_ID = " KEY_USER_ID";
    private static final String KEY_ACCOUNT = " KEY_ACCOUNT";

    //登录状态的token,用来接口请求
    private static String token;
    //登陆的用户Id
    private static String userId;
    //登陆的账户
    private static String account;

    //存储到XML文件，持久化
    private static void save(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Account.class.getName(), context.MODE_PRIVATE);
        // 存储数据
        sp.edit()
                .putString(KEY_TOKEN, token)
                .putString(KEY_USER_ID, userId)
                .putString(KEY_ACCOUNT, account)
                .apply();
    }


    /**
     * 进行数据加载
     */
    public static void load(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Account.class.getName(),
                Context.MODE_PRIVATE);
        token = sp.getString(KEY_TOKEN, "");
        userId = sp.getString(KEY_USER_ID, "");
        account = sp.getString(KEY_ACCOUNT, "");
    }


    /**
     * 返回用户Id
     *
     * @return 用户Id
     */
    public static String getUserId() {

        return TextUtils.isEmpty(userId)?"null":userId;
    }

    /**
     * 获取当前登录的Token
     *
     * @return Token
     */
    public static String getToken() {
        return token;
    }

}

