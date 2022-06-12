package com.service;

import java.util.List;

import com.biboheart.brick.exception.BhException;
import com.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface UserService {
    /**
     * 保存用户信息
     *
     * @param user
     *            用户信息对象
     * @return 保存成功后的用户信息或null
     */
    public User save(User user) throws BhException;


    /**
     * 删除用户
     *
     * @param id
     *            用户ID
     * @return 返回删除成功的用户信息或null
     */
    public User delete(Long id);

    /**
     * 查询用户信息
     *
     * @param id
     *            用户ID
     * @return 用户信息或null
     */
    public User load(Long id);

    /**
     * 用户列表
     *
     * @return 返回用户对象列表
     */
    public List<User> list();
    public Page<User> find(Integer page, Integer size);

    public boolean updateUserFlavor(long user_id,String flavor,float feedback);

    User checkUser(String username, String password);

    User exist(String username);

    User register(String username, String password, String mail);
}