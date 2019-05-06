package com.zyf.factory.data.helper;

import com.zyf.common.factory.data.base.DataSource;
import com.zyf.factory.model.fans.Fans;
import com.zyf.factory.model.fans.RequestModel_getFansList;
import java.util.ArrayList;
import java.util.List;

public class FansHelper {

    /**
     * @param model    传递一个fun1 model的接口
     * @param callback 成功与失败的接口回送
     */
    public static void getList(final RequestModel_getFansList model, final DataSource.Callback<List<Fans>> callback) {
        //调用Retrofit对我们的网络请求接口做代理
        //RemoteService service = NetWork.remote();

        //模拟网络获取了数据
        List<Fans> list = new ArrayList<>();

        Fans fans = new Fans("https://youimg1.c-ctrip.com/target/10020s000000hxqgv3498_R_671_10000_Q90.jpg?proc=autoorient","娜娜",true);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);
        list.add(fans);

        callback.onDataLoaded(list);
        /*
        //得到一个Call
        Call<RspModel<List<Dynamic>>> call = service.getList(model);
        //异步的请求
        call.enqueue(new Callback<RspModel<List<Dynamic>>>() {
            @Override
            public void onResponse(Call<RspModel<List<Dynamic>>> call, Response<RspModel<List<Dynamic>>> response) {
                RspModel<List<Dynamic>>rspModel = response.body();
                if(rspModel.success()){
                    callback.onDataLoaded(rspModel.getResult());
                }else {
                    Factory.decodeRspCode(rspModel,callback);
                }
            }

            @Override
            public void onFailure(Call<RspModel<List<Dynamic>>> call, Throwable t) {
                callback.onDataNotAvaliable(R.string.data_network_error);
            }
        });

        */


    }

}
