package com.zyf.factory.model.dynamic;


import java.io.Serializable;
import java.util.List;

/**
 * 一条动态  首页内部的三个小页面的列表的单项类
 * 实现序列化 使其可在四大组件中传递
 */
public class Dynamic implements Serializable {


    Author author;
    String title;
    String content;
    List<String> imgUrlList;
    String videoUrl;
    int likes;
    int collections;
    boolean isLike = false;


    public Dynamic(Author author, String title, String content, List<String> imgUrlList, String videoUrl, int likes, int collections, boolean isLike) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.imgUrlList = imgUrlList;
        this.videoUrl = videoUrl;
        this.likes = likes;
        this.collections = collections;
        this.isLike = isLike;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public List<String> getImgUrlList() {
        return imgUrlList;
    }

    public void setImgUrlList(List<String> imgUrlList) {
        this.imgUrlList = imgUrlList;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getCollections() {
        return collections;
    }

    public void setCollections(int collections) {
        this.collections = collections;
    }
}
