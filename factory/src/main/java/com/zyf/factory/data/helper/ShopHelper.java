package com.zyf.factory.data.helper;

import com.zyf.common.factory.data.base.DataSource;
import com.zyf.factory.model.shop.RequestModel_getShopList;
import com.zyf.factory.model.shop.Shop;
import java.util.ArrayList;
import java.util.List;

public class ShopHelper {
    //例子：fun1网络请求的方法(在fun1的presenter中去调用)

    /**
     * @param model    传递一个fun1 model的接口
     * @param callback 成功与失败的接口回送
     */
    public static void getList(final RequestModel_getShopList model, final DataSource.Callback<List<Shop>> callback) {
        //调用Retrofit对我们的网络请求接口做代理
        //RemoteService service = NetWork.remote();
        //模拟网络获取了数据
        List<Shop> list = new ArrayList<>();
        List<String> imgList = new ArrayList<>();
        imgList.add("https://youimg1.c-ctrip.com/target/10020s000000hxqgv3498_R_671_10000_Q90.jpg?proc=autoorient");
        imgList.add("https://youimg1.c-ctrip.com/target/100t0s000000hqv09EB5D_R_1024_10000_Q90.jpg?proc=autoorient");
        imgList.add("https://youimg1.c-ctrip.com/target/100q0s000000hs3uu9A7D_R_671_10000_Q90.jpg?proc=autoorient");
        imgList.add("https://youimg1.c-ctrip.com/target/100j0s000000hqg6u8C5E_R_1024_10000_Q90.jpg?proc=autoorient");
        imgList.add("https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient");

        List<Shop.Food>foods = new ArrayList<>();
        Shop.Food food = new Shop.Food("糖醋土豆","https://youimg1.c-ctrip.com/target/10020s000000hxqgv3498_R_671_10000_Q90.jpg?proc=autoorient",10);
        foods.add(food);
        food = new Shop.Food("糖醋土豆","https://youimg1.c-ctrip.com/target/100t0s000000hqv09EB5D_R_1024_10000_Q90.jpg?proc=autoorient",10);
        foods.add(food);
        food = new Shop.Food("糖醋土豆","https://youimg1.c-ctrip.com/target/100q0s000000hs3uu9A7D_R_671_10000_Q90.jpg?proc=autoorient",10);
        foods.add(food);
        food = new Shop.Food("糖醋土豆","https://youimg1.c-ctrip.com/target/100j0s000000hqg6u8C5E_R_1024_10000_Q90.jpg?proc=autoorient",10);
        foods.add(food);
        food = new Shop.Food("糖醋土豆","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient",10);
        foods.add(food);


        //店名，简介，头像，封面，食物列表
        list.add(new Shop("周签签锅巴土豆1","我们只做土豆~","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient",foods));
        list.add(new Shop("周签签锅巴土豆2","我们只做土豆~","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient",foods));
        list.add(new Shop("周签签锅巴土豆3","我们只做土豆~","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient",foods));
        list.add(new Shop("周签签锅巴土豆4","我们只做土豆~","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient",foods));
        list.add(new Shop("周签签锅巴土豆5","我们只做土豆~","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient",foods));
        list.add(new Shop("周签签锅巴土豆6","我们只做土豆~","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient","https://youimg1.c-ctrip.com/target/100h0s000000hs4ub12BD_R_671_10000_Q90.jpg?proc=autoorient",foods));


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
