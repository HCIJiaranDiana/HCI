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
    private String detailurl;; //详情链接
    private String shoptype; // 商户第一个标签


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

    public String getDetailurl() {
        return detailurl;
    }

    public void setDetailurl(String detailurl) {
        this.detailurl = detailurl;
    }

    public String getShoptype() {
        return shoptype;
    }

    public void setShoptype(String shoptype) {
        this.shoptype = shoptype;
    }
}
