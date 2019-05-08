package com.zyf.factory.model;

public class Person {
    //用户ID
    int id;
    //头像URL
    String iconUrl;
    //用户昵称
    String name;
    //是否已被我关注
    boolean isFollowing;

    public Person(String iconUrl, String name, boolean isFollowing) {
        this.iconUrl = iconUrl;
        this.name = name;
        this.isFollowing = isFollowing;
    }

    public int getId() {
        return id;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFollowing() {
        return isFollowing;
    }

    public void setFollowing(boolean following) {
        isFollowing = following;
    }
}
