package com.zyf.factory.model.shop;

import java.io.Serializable;
import java.util.List;

public class Shop implements Serializable {
    String name ;
    String brief;
    String iconUrl;
    String coverUrl;
    List<Food>foods;

    public Shop(String name, String brief, String iconUrl, String coverUrl, List<Food> foods) {
        this.name = name;
        this.brief = brief;
        this.iconUrl = iconUrl;
        this.coverUrl = coverUrl;
        this.foods = foods;
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public static class Food implements Serializable{
        String name;
        String imgUrl;
        int cost;

        public Food(String name, String imgUrl, int cost) {
            this.name = name;
            this.imgUrl = imgUrl;
            this.cost = cost;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }
}
