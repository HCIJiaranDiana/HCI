package com.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue
    private Long id; // 商店ID
    private String shopname; // 名称
    private float cost; //人均消费
    private String img; //图片地址
    private float review; //评分
    private float posx; //纬度
    private float posy; //经度
    private float detailurl;; //详情链接
    private int shoptype; // 商户第一个标签
    private int shoptype2; // 商户第二个标签


    public Long getShopId() {
        return id;
    }

    public void setShopId(Long shopId) {
        this.id = shopId;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getReview() {
        return review;
    }
    public void setReview(float review) {
        this.review = review;
    }

    public float getPosx() {
        return posx;
    }

    public void setPosx(float posx) {
        this.posx = posx;
    }

    public float getPosy() {
        return posy;
    }

    public void setPosy(float posy) {
        this.posy = posy;
    }

    public float getDetailurl() {
        return detailurl;
    }

    public void setDetailurl(float detailurl) {
        this.detailurl = detailurl;
    }

    public int getShoptype() {
        return shoptype;
    }

    public void setShoptype(int shoptype) {
        this.shoptype = shoptype;
    }
    public int getShoptype2() {
        return shoptype2;
    }

    public void setShoptype2(int shoptype2) {
        this.shoptype2 = shoptype2;
    }
}
