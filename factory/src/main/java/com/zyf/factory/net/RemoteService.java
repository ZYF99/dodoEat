package com.zyf.factory.net;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class RemoteService {

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
