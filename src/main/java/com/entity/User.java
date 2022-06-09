package com.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "bh_user_user")
public class User {
    @Id
    @GeneratedValue
    private Long id; // 用户ID
    private String username; // 用户名称
    private String password; // 用户名称
    private String phone; // 电话号码
    private Long birthday; // 生日
    private Long createTime; // 创建时间
    private Long updateTime; // 最后修改时间
    private Integer userType;

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.id = userId;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {return userType;}
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

}