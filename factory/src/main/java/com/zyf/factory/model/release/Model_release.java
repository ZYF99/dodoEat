package com.zyf.factory.model.release;

import android.net.Uri;

import java.util.List;

/**
 * 上传动态时需要的参数model
 */
public class Model_release {
    int userId;
    List<String>imgList;
    String title;
    String content;
    String position;

    public Model_release(int userId, List<String> imgList, String title, String content, String position) {
        this.userId = userId;
        this.imgList = imgList;
        this.title = title;
        this.content = content;
        this.position = position;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
