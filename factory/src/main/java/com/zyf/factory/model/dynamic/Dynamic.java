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
    String vidieoUrl;
    boolean isLike = false;

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    int likes;
    int collection;


    public Dynamic() {
        this.author = null;
        this.title = "";
        this.content = "";
        this.imgUrlList = null;
        this.vidieoUrl = null;
        this.likes = -1;
        this.collection = -1;
    }

    //构造含有图片列表的对象
    public Dynamic(Author author, String title, String content, List<String> imgUrlList, int likes, int collection) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.imgUrlList = imgUrlList;
        this.vidieoUrl = null;
        this.likes = likes;
        this.collection = collection;
    }

    //构造含有视频的对象
    public Dynamic(Author author, String title, String content, String vidieoUrl, int likes, int collection) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.vidieoUrl = vidieoUrl;
        this.imgUrlList = null;
        this.likes = likes;
        this.collection = collection;
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

    public String getVidieoUrl() {
        return vidieoUrl;
    }

    public void setVidieoUrl(String vidieoUrl) {
        this.vidieoUrl = vidieoUrl;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }



    @Override
    public String toString() {
        return "Dynamic{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgUrlList=" + imgUrlList +
                ", vidieoUrl='" + vidieoUrl + '\'' +
                ", likes=" + likes +
                ", collection=" + collection +
                '}';
    }
}
