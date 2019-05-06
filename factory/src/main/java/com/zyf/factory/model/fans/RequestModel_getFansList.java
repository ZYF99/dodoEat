package com.zyf.factory.model.fans;


/**
 * 用于获取动态列表的请求model
 */

public class RequestModel_getFansList {

    int userId;

    public RequestModel_getFansList(int userId){

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
