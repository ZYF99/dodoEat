package com.zyf.factory.data.helper;

import com.zyf.common.factory.data.base.DataSource;
import com.zyf.factory.model.Person;
import com.zyf.factory.model.fans.RequestModel_getFansList;
import com.zyf.factory.model.following.RequestModel_getFollowingList;

import java.util.ArrayList;
import java.util.List;


/**
 * 获取用户列表的工具类
 */
public class PersonHelper {

    /**
     * @param model    传递一个fun1 model的接口
     * @param callback 成功与失败的接口回送
     */
    public static void getFansList(final RequestModel_getFansList model, final DataSource.Callback<List<Person>> callback) {
        //调用Retrofit对我们的网络请求接口做代理
        //RemoteService service = NetWork.remote();

        //模拟网络获取了数据
        List<Person> list = new ArrayList<>();

        Person person = new Person("http://img0w.pconline.com.cn/pconline/1403/29/spcgroup/width_640,qua_30/4523636_07.jpg", "说得好", true);
        list.add(person);
        person = new Person("http://b-ssl.duitang.com/uploads/item/201706/22/20170622131955_h4eZS.thumb.700_0.jpeg", "楠囡", false);
        list.add(person);
        person = new Person("http://g.hiphotos.baidu.com/zhidao/pic/item/d833c895d143ad4bd74bac3f85025aafa50f06e3.jpg", "哈哈哈", false);
        list.add(person);
        person = new Person("http://pic14.nipic.com/20110531/1962311_202040194380_2.jpg", "楠囡", false);
        list.add(person);
        person = new Person("http://b-ssl.duitang.com/uploads/item/201505/02/20150502133843_uaHR3.jpeg", "娜娜", true);
        list.add(person);
        person = new Person("http://b-ssl.duitang.com/uploads/item/201510/05/20151005144251_LXtsH.jpeg", "我的世界", false);
        list.add(person);
        person = new Person("http://img0.pconline.com.cn/pconline/1509/29/7016578_2546_thumb.jpg", "多发病", false);
        list.add(person);


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

    /**
     * @param model    传递一个fun1 model的接口
     * @param callback 成功与失败的接口回送
     */
    public static void getFollowingList(final RequestModel_getFollowingList model, final DataSource.Callback<List<Person>> callback) {
        //调用Retrofit对我们的网络请求接口做代理
        //RemoteService service = NetWork.remote();

        //模拟网络获取了数据
        List<Person> list = new ArrayList<>();

        Person person = new Person("http://img0w.pconline.com.cn/pconline/1403/29/spcgroup/width_640,qua_30/4523636_07.jpg", "说得好", true);
        list.add(person);
        person = new Person("http://b-ssl.duitang.com/uploads/item/201706/22/20170622131955_h4eZS.thumb.700_0.jpeg", "楠囡", false);
        list.add(person);
        person = new Person("http://g.hiphotos.baidu.com/zhidao/pic/item/d833c895d143ad4bd74bac3f85025aafa50f06e3.jpg", "哈哈哈", false);
        list.add(person);
        person = new Person("http://pic14.nipic.com/20110531/1962311_202040194380_2.jpg", "楠囡", false);
        list.add(person);
        person = new Person("http://b-ssl.duitang.com/uploads/item/201505/02/20150502133843_uaHR3.jpeg", "娜娜", true);
        list.add(person);
        person = new Person("http://b-ssl.duitang.com/uploads/item/201510/05/20151005144251_LXtsH.jpeg", "我的世界", false);
        list.add(person);
        person = new Person("http://img0.pconline.com.cn/pconline/1509/29/7016578_2546_thumb.jpg", "多发病", false);
        list.add(person);


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
