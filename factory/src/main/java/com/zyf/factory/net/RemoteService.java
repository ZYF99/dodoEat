package com.zyf.factory.net;

import com.zyf.factory.model.RspModel;
import com.zyf.factory.model.dynamic.Dynamic;
import com.zyf.factory.model.dynamic.RequestModel_getDynamicList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RemoteService {


    //获取动态列表的请求
    @GET("user/contact")
    Call<RspModel<List<Dynamic>>> getList(RequestModel_getDynamicList model);


    /**
     * 获取联系人列表
     *
     * @param
     * @return RspModel<UserCard>
     */

/*    @GET("user/contact")
    Call<RspModel<List<UserCard>>> userContacts();*/


    /**
     * 网络请求一个注册接口
     *
     * @param model 传入的是RegisterModel
     * @return 返回的是RspModel<AccountRspModel>
     */

/*    @POST("account/register")
    Call<RspModel<AccountRspModel>> accountRegister(@Body RegisterModel model);*/


    /**
     * 用户关注的接口
     *
     * @param userId String
     * @return RspModel<UserCard>
     */

/*    @PUT("user/follow/{userId}")
    Call<RspModel<UserCard>> userFollow(@Path("userId") String userId);*/



}
