package com.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "user_preference")
public class UserPreference {
    @Id
    @GeneratedValue
    private Long id; // 用户ID

    private float price_pre; //用户对于价格的偏好权重

    private float pos_pre; //用户对于距离的偏好权重

    private float review_pre; //用户对于评价的偏好权重

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.id = userId;
    }

    public float getPrice_pre() {
        return price_pre;
    }

    public void setPrice_pre(float price_pre) {
        this.price_pre = price_pre;
    }

    public float getPos_pre() {
        return pos_pre;
    }

    public void setPos_pre(float pos_pre) {
        this.pos_pre = pos_pre;
    }

    public float getReview_pre() {
        return review_pre;
    }

    public void setReview_pre(float review_pre) {
        this.review_pre = review_pre;
    }
}
