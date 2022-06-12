package com.serviceimpl;

import java.util.List;

import com.biboheart.brick.exception.BhException;
import com.biboheart.brick.utils.CheckUtils;
import com.biboheart.brick.utils.TimeUtils;
import com.constant.Constant;
import com.dao.UserDao;
import com.entity.User;
import com.entity.UserFlavor;
import com.repository.UserFlavorRepository;
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
    private UserFlavorRepository userFlavorRepository;
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

    @Override
    public boolean updateUserFlavor(long user_id,String flavor,float feedback){
        User user = userRepository.findById(user_id).get();
        if (user == null) {
            return false;
        }
        UserFlavor userFlavor = userFlavorRepository.findById(user_id).get();
        if (userFlavor == null) {
            return false;
        }
        if (flavor == Constant.TAG_1) {
            float newValue = userFlavor.getTag1() + feedback;
            userFlavor.setTag1(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_2) {
            float newValue = userFlavor.getTag2() + feedback;
            userFlavor.setTag2(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_3) {
            float newValue = userFlavor.getTag3() + feedback;
            userFlavor.setTag3(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_4) {
            float newValue = userFlavor.getTag4() + feedback;
            userFlavor.setTag4(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_5) {
            float newValue = userFlavor.getTag5() + feedback;
            userFlavor.setTag5(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_6) {
            float newValue = userFlavor.getTag6() + feedback;
            userFlavor.setTag6(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_7) {
            float newValue = userFlavor.getTag7() + feedback;
            userFlavor.setTag7(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_8) {
            float newValue = userFlavor.getTag8() + feedback;
            userFlavor.setTag8(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_9) {
            float newValue = userFlavor.getTag9() + feedback;
            userFlavor.setTag9(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_10) {
            float newValue = userFlavor.getTag10() + feedback;
            userFlavor.setTag10(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_11) {
            float newValue = userFlavor.getTag11() + feedback;
            userFlavor.setTag11(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_12) {
            float newValue = userFlavor.getTag12() + feedback;
            userFlavor.setTag12(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_13) {
            float newValue = userFlavor.getTag13() + feedback;
            userFlavor.setTag13(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_14) {
            float newValue = userFlavor.getTag14() + feedback;
            userFlavor.setTag14(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_15) {
            float newValue = userFlavor.getTag15() + feedback;
            userFlavor.setTag15(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_16) {
            float newValue = userFlavor.getTag16() + feedback;
            userFlavor.setTag16(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_17) {
            float newValue = userFlavor.getTag17() + feedback;
            userFlavor.setTag17(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_18) {
            float newValue = userFlavor.getTag18() + feedback;
            userFlavor.setTag18(newValue);
            return true;
        }
        else if (flavor == Constant.TAG_19) {
            float newValue = userFlavor.getTag19() + feedback;
            userFlavor.setTag19(newValue);
            return true;
        }
        else {
            return false;
        }

    }
}