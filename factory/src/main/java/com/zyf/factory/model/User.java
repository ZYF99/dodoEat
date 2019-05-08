package com.zyf.factory.model;

//本用户，全局单例
public class User {
    static User user;
    int id;                             //吃货账号
    String name;                       //昵称
    int sex;                           //性别 0男 1女
    String iconUrl;                   //头像URL
    int num_following;               //我关注的人数
    int num_fans;                   //粉丝
    int num_likesAndCollect;       //获赞与收藏数
    String address;               //地址
    int levelV;                  //Vip等级

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getNum_following() {
        return num_following;
    }

    public void setNum_following(int num_following) {
        this.num_following = num_following;
    }

    public int getNum_fans() {
        return num_fans;
    }

    public void setNum_fans(int num_fans) {
        this.num_fans = num_fans;
    }

    public int getNum_likesAndCollect() {
        return num_likesAndCollect;
    }

    public void setNum_likesAndCollect(int num_likesAndCollect) {
        this.num_likesAndCollect = num_likesAndCollect;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLevelV() {
        return levelV;
    }

    public void setLevelV(int levelV) {
        this.levelV = levelV;
    }
}
