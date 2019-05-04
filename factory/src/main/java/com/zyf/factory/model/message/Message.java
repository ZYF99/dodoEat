package com.zyf.factory.model.message;


import java.io.Serializable;

public class Message implements Serializable {
        String iconUrl;
        String title;
        String msg;
        String time;

    public Message(String iconUrl, String title, String msg, String time) {
        this.iconUrl = iconUrl;
        this.title = title;
        this.msg = msg;
        this.time = time;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "iconUrl='" + iconUrl + '\'' +
                ", title='" + title + '\'' +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
