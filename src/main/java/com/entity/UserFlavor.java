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

    private float tag10; //用户对于tag10的偏好权重

    private float tag11; //用户对于tag11的偏好权重

    private float tag12; //用户对于tag12的偏好权重

    private float tag13; //用户对于tag13的偏好权重

    private float tag14; //用户对于tag14的偏好权重

    private float tag15; //用户对于tag15的偏好权重

    private float tag16; //用户对于tag16的偏好权重

    private float tag17; //用户对于tag17的偏好权重

    private float tag18; //用户对于tag18的偏好权重

    private float tag19; //用户对于tag19的偏好权重
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

    public float getTag10() {
        return tag10;
    }

    public float getTag11() {
        return tag11;
    }

    public float getTag12() {
        return tag12;
    }

    public float getTag13() {
        return tag13;
    }

    public float getTag14() {
        return tag14;
    }

    public float getTag15() {
        return tag15;
    }

    public float getTag16() {
        return tag16;
    }

    public float getTag17() {
        return tag17;
    }

    public float getTag18() {
        return tag18;
    }

    public float getTag19() {
        return tag19;
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

    public void setTag10(float tag10) {
        this.tag10 = tag10;
    }

    public void setTag11(float tag11) {
        this.tag11 = tag11;
    }

    public void setTag12(float tag12) {
        this.tag12 = tag12;
    }

    public void setTag13(float tag13) {
        this.tag13 = tag13;
    }

    public void setTag14(float tag14) {
        this.tag14 = tag14;
    }

    public void setTag15(float tag15) {
        this.tag15 = tag15;
    }

    public void setTag16(float tag16) {
        this.tag16 = tag16;
    }

    public void setTag17(float tag17) {
        this.tag17 = tag17;
    }

    public void setTag18(float tag18) {
        this.tag8 = tag18;
    }

    public void setTag19(float tag19) {
        this.tag9 = tag19;
    }
}
