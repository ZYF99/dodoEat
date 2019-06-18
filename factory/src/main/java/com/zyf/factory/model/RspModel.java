package com.zyf.factory.model;

import java.util.Date;

public class RspModel<T> {
/*
    //以下是返回的参数例子：请自行修改

    public static final int SUCCEED = 1;
    public static final int ERROR_UNKNOWN = 0;
    private int code;
    private String message;
    private Date time;*/

    //最重要的返回的类型的对象
    private T result;


    //得到特有功能返回的特有对象
    public T getResult() {
        return result;
    }


/*    //判断回送的数据是否成功
    public boolean success() {
        return code == SUCCEED;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }*/
}
