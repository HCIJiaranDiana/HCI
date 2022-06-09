package com.serviceimpl;

import java.util.List;

import com.biboheart.brick.exception.BhException;
import com.biboheart.brick.utils.CheckUtils;
import com.biboheart.brick.utils.TimeUtils;
import com.dao.UserDao;
import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDao userDao;
    @Override
    public User save(User user) throws BhException {
        if (null == user.getId()) {
            user.setId(0L);
        }
        // 以下用到了 com.biboheart.brick 中的BhException,CheckUtils.isEmpty,TimeUtils.getCurrentTimeInMillis
        if (CheckUtils.isEmpty(user.getName())) {
            throw new BhException("用户名称不能为空");
        }
        Long now = TimeUtils.getCurrentTimeInMillis(); // 取当前时间戳
        if (CheckUtils.isEmpty(user.getCreateTime())) {
            user.setCreateTime(now);
        }
        user.setUpdateTime(now);
        user = userRepository.save(user);
        return user;
    }




    @Override
    public User delete(Long id) {
        if (CheckUtils.isEmpty(id)) {
            return null;
        }
        User user = userRepository.findById(id).get();
        if (null != user) {
            userRepository.delete(user);
        }
        return user;
    }

    @Override
    public User load(Long id) {
        if (CheckUtils.isEmpty(id)) {
            return null;
        }
        User user = userRepository.findById(id).get();
        return user;
    }

    @Override
    public List<User> list() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public Page<User> find(Integer page, Integer size) {
        if (null == page) {
            page = 0;
        }
        if (CheckUtils.isEmpty(size)) {
            size = 10;
        }
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, "updateTime");
        Page<User> users = userRepository.findAll(pageable);
        return users;
    }

    public User checkUser(String username, String password){
        return userDao.checkUser(username,password);
    }

    public User exist(String username){
        return userDao.exist(username);
    }
    public User register(String username,String password,String mail){
        return userDao.register(username,password,mail);
    }
}