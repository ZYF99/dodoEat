package com.zyf.factory.model.fans;

public class Fans {
    String iconUrl;
    String name;
    boolean isFollowing;

    public Fans(String iconUrl, String name, boolean isFollowing) {
        this.iconUrl = iconUrl;
        this.name = name;
        this.isFollowing = isFollowing;
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
