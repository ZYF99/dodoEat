package com.zyf.factory.net;

import com.zyf.common.common.Common;
import com.zyf.factory.Factory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWork {

    private static NetWork instance;

    private Retrofit retrofit;

    static {
        instance = new NetWork();
    }

    private NetWork() {

    }

    //构建一个Retrofit
    public static Retrofit getRetrofit() {
        if (instance.retrofit != null) {
            return instance.retrofit;
        }
        //获得一个OK的Client
        OkHttpClient client = new OkHttpClient.Builder()
                //给所有的请求添加一个拦截器
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        //拿到我们的请求
                        Request original = chain.request();
                        //重新进行builder
                        Request.Builder builder = original.newBuilder();

              /*          if(!TextUtils.isEmpty(Model.getToken()))//获取全局Model的token// 的token，有就加入header
                        {
                            builder.addHeader("token",Model.getToken())
                        }*/
                        builder.addHeader("Content-Type", "application/json");
                        Request newrequest = builder.build();
                        //返回
                        return chain.proceed(newrequest);
                    }
                })
                .build();
        Retrofit.Builder builder = new Retrofit.Builder();
        //设置链接
        instance.retrofit = builder.baseUrl(Common.Constance.API_URL)
                //设置client
                .client(client)
                //设置json解析器
                .addConverterFactory(GsonConverterFactory.create(Factory.getGson()))
                .build();
        return instance.retrofit;

    }

    /**
     * 返回一个请求代理
     */
    public static RemoteService remote() {
        //调用Retrofit对我们的网络接口请求代理
        return NetWork.getRetrofit().create(RemoteService.class);
    }

}
