package com.zyf.factory.data.helper;

import android.util.Log;
import com.zyf.common.factory.data.base.DataSource;
import com.zyf.factory.Factory;
import com.zyf.factory.R;
import com.zyf.factory.model.RspModel;
import com.zyf.factory.model.fun1.Fun1DataModel;
import com.zyf.factory.model.fun1.Fun1Model;
import com.zyf.factory.model.fun1.Fun1RspModel;
import com.zyf.factory.net.NetWork;
import com.zyf.factory.net.RemoteService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * fun1界面的功能实现
 * 网络数据拉取之类的
 * */
public class Fun1Helper {

    //例子：fun1网络请求的方法(在fun1的presenter中去调用)
    /**
     * @param model    传递一个fun1 model的接口
     * @param callback 成功与失败的接口回送
     */
    public static void fun1(final Fun1Model model, final DataSource.Callback<Fun1DataModel> callback) {
        //调用Retrofit对我们的网络请求接口做代理
        RemoteService service = NetWork.remote();
        //得到一个Call
        Call<RspModel<Fun1RspModel>> call = service.fun1(model);
        //异步的请求
        call.enqueue(new Fun1RspCallback(callback));

    }

    /**
     * 请求的回调部分封装
     */
    private static class Fun1RspCallback implements Callback<RspModel<Fun1RspModel>> {

        final DataSource.Callback<Fun1DataModel> callback;

        Fun1RspCallback(DataSource.Callback<Fun1DataModel> callback) {
            this.callback = callback;
        }

        @Override
        public void onResponse(Call<RspModel<Fun1RspModel>> call
                , Response<RspModel<Fun1RspModel>> response) {
            //请求成功返回
            //从返回中得到我们的全局Model，内部是使用的Gson进行解析
            RspModel<Fun1RspModel> rspModel = response.body();
            Log.d("RSP", rspModel.toString());
            if (rspModel.success()) {
                //拿到实体
                Fun1RspModel fun1RspModel = rspModel.getResult();
                //获取返回的我想要的的数据Model
                final Fun1DataModel fun1DataModel = fun1RspModel.getFun1DataModel();

            } else {
                //错误解析
                Factory.decodeRspCode(rspModel, callback);
            }

        }
        @Override
        public void onFailure(Call<RspModel<Fun1RspModel>> call, Throwable t) {
            //网络请求失败
            if (callback != null) {
                callback.onDataNotAvaliable(R.string.data_network_error);
            }

        }

    }



}
