package com.zyf.factory.model.dynamic;


import java.util.HashMap;

/**
 * 用于获取动态列表的请求model
 */

public class RequestModel_getDynamicList {

    int startPage;
    int endPage;
    public RequestModel_getDynamicList(int startPage,int endPage){
        this.startPage = startPage;
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "RequestModel_getDynamicList{" +
                "startPage='" + startPage + '\'' +
                ", endPage='" + endPage + '\'' +
                '}';
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public HashMap<String,Integer>getHashMap(){
        HashMap<String,Integer>map = new HashMap<>();
        map.put("startPage",startPage);
        map.put("endPage",endPage);
        return map;
    }
}
