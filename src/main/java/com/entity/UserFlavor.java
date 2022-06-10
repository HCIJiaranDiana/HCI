package com.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "user_flavor")
public class UserFlavor {
    @Id
    @GeneratedValue
    private Long id; // 用户ID

    private float tag1; //用户对于tag1的偏好权重

    private float tag2; //用户对于tag2的偏好权重

    private float tag3; //用户对于tag3的偏好权重

    private float tag4; //用户对于tag4的偏好权重

    private float tag5; //用户对于tag5的偏好权重

    private float tag6; //用户对于tag6的偏好权重

    private float tag7; //用户对于tag7的偏好权重

    private float tag8; //用户对于tag8的偏好权重

    private float tag9; //用户对于tag9的偏好权重

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.id = userId;
    }

    public float getTag1() {
        return tag1;
    }

    public float getTag2() {
        return tag2;
    }

    public float getTag3() {
        return tag3;
    }

    public float getTag4() {
        return tag4;
    }

    public float getTag5() {
        return tag5;
    }

    public float getTag6() {
        return tag6;
    }

    public float getTag7() {
        return tag7;
    }

    public float getTag8() {
        return tag8;
    }

    public float getTag9() {
        return tag9;
    }

    public void setTag1(float tag1) {
        this.tag1 = tag1;
    }

    public void setTag2(float tag2) {
        this.tag2 = tag2;
    }

    public void setTag3(float tag3) {
        this.tag3 = tag3;
    }

    public void setTag4(float tag4) {
        this.tag4 = tag4;
    }

    public void setTag5(float tag5) {
        this.tag5 = tag5;
    }

    public void setTag6(float tag6) {
        this.tag6 = tag6;
    }

    public void setTag7(float tag7) {
        this.tag7 = tag7;
    }

    public void setTag8(float tag8) {
        this.tag8 = tag8;
    }

    public void setTag9(float tag9) {
        this.tag9 = tag9;
    }
}
