package com.zyf.factory.data.helper;

import com.zyf.common.factory.data.base.DataSource;
import com.zyf.factory.model.User;
import com.zyf.factory.model.launch.RequestModel_getUserInfo;


public class UserHelper {

    /**
     * @param model_getUserInfo model    传递一个fun1 model的接口
     * @param callback 成功与失败的接口回送
     */
    public static void getUserInfo(final RequestModel_getUserInfo model_getUserInfo, final DataSource.Callback<User> callback) {
        //调用Retrofit对我们的网络请求接口做代理
        //RemoteService service = NetWork.remote();


        //模拟网络获取了数据
        User user = User.getInstance();
        //数据设置
        user.setId(86486543);
        user.setName("风在说话");
        user.setSex(1);
        user.setIconUrl("http://b-ssl.duitang.com/uploads/item/201706/22/20170622131955_h4eZS.thumb.700_0.jpeg");
        user.setNum_fans(100);
        user.setNum_following(200);
        user.setNum_likesAndCollect(325);
        user.setAddress("四川省成都市");
        user.setLevelV(8);


        callback.onDataLoaded(user);
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
