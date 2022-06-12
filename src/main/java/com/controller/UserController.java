package com.controller;

import com.biboheart.brick.exception.BhException;
import com.biboheart.brick.model.BhResponseResult;
import com.constant.Constant;
import com.entity.Shop;
import com.entity.User;
import com.entity.UserFlavor;
import com.entity.UserPreference;
import com.service.ShopService;
import com.service.UserFlavorService;
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
    @Autowired
    private ShopService shopService;
    @Autowired
    private UserFlavorService userFlavorService;


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

    /**
     * 处理用户回馈
     * @param user_id 用户id
     * @param feedback 用户回馈
     * @return
     */
    @RequestMapping(value = "/handlefeedback")
    public boolean handlefeedback(Long user_id,int feedback) {
        User user = userService.load(user_id);
        if(user == null) {
            return false;
        }
        UserFlavor userFlavor = userFlavorService.load(user_id);
        if(userFlavor == null) {
            return false;
        }
        long lastShopId = user.getlastShopId();
        Shop lastShop = shopService.load(lastShopId);
        String lastShopType = lastShop.getShoptype();
        if (lastShopType == Constant.TAG_1) {
            float oldValue = userFlavor.getTag1() + feedback;
            userFlavor.setTag1(oldValue);
            return true;
        }
        else if (lastShopType == Constant.TAG_2) {
            float oldValue = userFlavor.getTag2() + feedback;
            userFlavor.setTag2(oldValue);
            return true;
        }
        else if (lastShopType == Constant.TAG_3) {
            float oldValue = userFlavor.getTag3() + feedback;
            userFlavor.setTag3(oldValue);
            return true;
        }
        else if (lastShopType == Constant.TAG_4) {
            float oldValue = userFlavor.getTag4() + feedback;
            userFlavor.setTag4(oldValue);
            return true;
        }
        else if (lastShopType == Constant.TAG_5) {
            float oldValue = userFlavor.getTag5() + feedback;
            userFlavor.setTag5(oldValue);
            return true;
        }
        else if (lastShopType == Constant.TAG_6) {
            float oldValue = userFlavor.getTag6() + feedback;
            userFlavor.setTag6(oldValue);
            return true;
        }
        else {
            return false;
        }
    }
}
