package com.dao;

import com.entity.User;

import java.util.Date;
import java.util.List;

public interface UserDao {

    User checkUser(String username, String password);

    User register(String username, String password);

    User exist(String username);

}
