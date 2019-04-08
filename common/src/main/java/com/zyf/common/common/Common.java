package com.zyf.common.common;

public class Common {
    /**
     * 一些不可变的永恒的参数
     * 通常用于一些配置
     */
    public interface Constance {
        //基础的网络请求地址 外网用这个
        String API_URL = "http://192.168.43.66:8080/api/";

        //插路由器用这个
        //String API_URL = "http://10.98.45.194:8080/api/";
    }
}
