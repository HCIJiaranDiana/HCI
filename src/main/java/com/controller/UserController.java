package com.controller;

import com.biboheart.brick.exception.BhException;
import com.biboheart.brick.model.BhResponseResult;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 保存用户信息
     * @param user 用户信息对象
     * @return
     * @throws BhException
     */
    @RequestMapping(value = "/userapi/user/save", method = {RequestMethod.POST})
    public BhResponseResult<?> register(User user) throws BhException {
        user = userService.save(user);
        return new BhResponseResult<>(0, "success", user);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/userapi/user/delete", method = {RequestMethod.POST, RequestMethod.GET})
    public BhResponseResult<?> delete(Long id) {
        User user = userService.delete(id);
        return new BhResponseResult<>(0, "success", user);
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/userapi/user/load", method = {RequestMethod.POST, RequestMethod.GET})
    public BhResponseResult<?> load(Long id) {
        User user = userService.load(id);
        return new BhResponseResult<>(0, "success", user);
    }

    /**
     * 用户列表
     * @return
     */
    @RequestMapping(value = "/userapi/user/list", method = {RequestMethod.POST, RequestMethod.GET})
    public BhResponseResult<?> list() {
        List<User> users = userService.list();
        return new BhResponseResult<>(0, "success", users);
    }
    @RequestMapping(value = "/userapi/user/find", method = {RequestMethod.POST, RequestMethod.GET})
    public BhResponseResult<?> find(Integer pageOffset, Integer pageSize) {
        Page<User> users = userService.find(pageOffset, pageSize);
        return new BhResponseResult<>(0, "success", users);
    }
}
