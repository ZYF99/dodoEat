package com.zyf.factory.model.following;


/**
 * 用于获取动态列表的请求model
 */

public class RequestModel_getFollowingList {

    int userId;

    public RequestModel_getFollowingList(int userId){

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
