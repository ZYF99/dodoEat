package com.zyf.factory.model.launch;


/**
 * 用于获取动态列表的请求model
 */

public class RequestModel_getUserInfo {

    int userId;

    public RequestModel_getUserInfo(int userId){

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
