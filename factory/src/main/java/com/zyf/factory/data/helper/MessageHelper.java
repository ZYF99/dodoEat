package com.zyf.factory.data.helper;

import com.zyf.common.factory.data.base.DataSource;
import com.zyf.factory.model.homepage.Author;
import com.zyf.factory.model.homepage.Dynamic;
import com.zyf.factory.model.homepage.RequestModel_getDynamicList;
import com.zyf.factory.model.message.Message;
import com.zyf.factory.model.message.RequestModel_getMessageList;

import java.util.ArrayList;
import java.util.List;

public class MessageHelper {

    /**
     * @param model    传递一个fun1 model的接口
     * @param callback 成功与失败的接口回送
     */
    public static void getList(final RequestModel_getMessageList model, final DataSource.Callback<List<Message>> callback) {
        //调用Retrofit对我们的网络请求接口做代理
        //RemoteService service = NetWork.remote();


        //模拟网络获取了数据
        List<Message> list = new ArrayList<>();
        Message message = new Message("https://avatar.csdn.net/C/7/9/3_b1412.jpg","吃货成都","吃在中国，味在四川","14:20");
        list.add(message);
        list.add(message);
        list.add(message);


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
