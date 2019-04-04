package com.zyf.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zyf.common.common.app.Application;
import com.zyf.factory.utils.AExclusionStrategy;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Factory {
    private static final Factory instance;
    //全局线程池
    private final Executor executor;
    //全局Gson
    private final Gson gson;

    static {
        instance = new Factory();
    }

    private Factory() {
        //新建一个4个线程的线程池
        executor = Executors.newFixedThreadPool(4);
        gson = new GsonBuilder()
                //设置时间格式
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
                //TODO 设置过滤器 过滤器在Util包中
                .setExclusionStrategies(new AExclusionStrategy())
                .create();
    }

    /**
     * Factovry中的初始化
     */
    public static void setup() {


    }

    /**
     * 返回全局的Application
     */
    public static Application app() {
        return Application.getInstance();
    }

    /**
     * 利用线程池异步运行的方法
     */
    public static void runOnAsync(Runnable runnable) {
        //拿到单例和线程池是，然后异步运行
        instance.executor.execute(runnable);
    }

    /**
     * 返回一个全局Gson 可以在这里进行gson的一些全局初始化
     */
    public static Gson getGson() {
        return instance.gson;
    }

}
