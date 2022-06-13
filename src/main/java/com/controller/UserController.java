package com.controller;

import com.biboheart.brick.exception.BhException;
import com.biboheart.brick.model.BhResponseResult;
import com.entity.Shop;
import com.entity.User;
import com.entity.UserFlavor;
import com.entity.UserPreference;
import com.service.ShopService;
import com.service.UserFlavorService;
import com.service.UserPreferenceService;
import com.service.UserService;
import net.sf.json.JSONObject;
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
    private UserFlavorService userFlavorService;
    @Autowired
    private UserPreferenceService userPreferenceService;

    @Autowired
    private ShopService shopService;

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


    /**
     * 处理用户回馈
     * @param user_id 用户id
     * @param feedback 用户回馈
     * @return
     */
    @RequestMapping(value = "/handlefeedback")
    public boolean handlefeedback(Long user_id,float feedback) {
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
        boolean ret = userService.updateUserFlavor(user_id,lastShopType,feedback);
        return ret;
    }
    /**
     * 处理用户w问卷
     * @param userid 用户id
     * @param param 用户问卷结果
     * @return
     */
    @RequestMapping(value = "/handlequiz")
    public boolean handlequiz(Long userid, JSONObject param) throws BhException{
        User user = userService.load(userid);
        if(user == null) {
            return false;
        }
        UserFlavor userFlavor = userFlavorService.load(userid);
        if(userFlavor == null) {
            return false;
        }
        UserPreference userPreference = userPreferenceService.load(userid);
        if(userPreference == null) {
            return false;
        }
        float tag1 = Float.parseFloat(param.getString("tag1"));
        float tag2 = Float.parseFloat(param.getString("tag2"));
        float tag3 = Float.parseFloat(param.getString("tag3"));
        float tag4 = Float.parseFloat(param.getString("tag4"));
        float tag5 = Float.parseFloat(param.getString("tag5"));
        float tag6 = Float.parseFloat(param.getString("tag6"));
        float tag7 = Float.parseFloat(param.getString("tag7"));
        float tag8 = Float.parseFloat(param.getString("tag8"));
        float tag9 = Float.parseFloat(param.getString("tag9"));
        float tag10 = Float.parseFloat(param.getString("tag10"));
        float tag11 = Float.parseFloat(param.getString("tag11"));
        float tag12 = Float.parseFloat(param.getString("tag12"));
        float tag13 = Float.parseFloat(param.getString("tag13"));
        float tag14 = Float.parseFloat(param.getString("tag14"));
        float tag15 = Float.parseFloat(param.getString("tag15"));
        float tag16 = Float.parseFloat(param.getString("tag16"));
        float tag17 = Float.parseFloat(param.getString("tag17"));
        float tag18 = Float.parseFloat(param.getString("tag18"));
        float tag19 = Float.parseFloat(param.getString("tag19"));
        float pospre = Float.parseFloat(param.getString("pospre"));
        float pricepre = Float.parseFloat(param.getString("pricepre"));
        float reviewpre = Float.parseFloat(param.getString("reviewpre"));

        userPreference.setPos_pre(pospre);
        userPreference.setPos_pre(pricepre);
        userPreference.setPos_pre(reviewpre);
        userPreferenceService.save(userPreference);

        userFlavor.setTag1(tag1);
        userFlavor.setTag2(tag2);
        userFlavor.setTag3(tag3);
        userFlavor.setTag4(tag4);
        userFlavor.setTag5(tag5);
        userFlavor.setTag6(tag6);
        userFlavor.setTag7(tag7);
        userFlavor.setTag8(tag8);
        userFlavor.setTag9(tag9);
        userFlavor.setTag10(tag10);
        userFlavor.setTag11(tag11);
        userFlavor.setTag12(tag12);
        userFlavor.setTag13(tag13);
        userFlavor.setTag14(tag14);
        userFlavor.setTag15(tag15);
        userFlavor.setTag16(tag16);
        userFlavor.setTag17(tag17);
        userFlavor.setTag18(tag18);
        userFlavor.setTag19(tag19);
        userFlavorService.save(userFlavor);

        user.setUserType(1);
        userService.save(user);
        return true;
    }
    /**
     * 处理用户w问卷
     * @param userid 用户id
     * @param param 用户问卷结果
     * @return
     */
    @RequestMapping(value = "/handleprechange")
    public boolean handleprechange(Long userid, JSONObject param) throws BhException{
        User user = userService.load(userid);
        if(user == null) {
            return false;
        }
        UserPreference userPreference = userPreferenceService.load(userid);
        if(userPreference == null) {
            return false;
        }
        float pospre = Float.parseFloat(param.getString("pospre"));
        float pricepre = Float.parseFloat(param.getString("pricepre"));
        float reviewpre = Float.parseFloat(param.getString("reviewpre"));

        userPreference.setPos_pre(pospre);
        userPreference.setPos_pre(pricepre);
        userPreference.setPos_pre(reviewpre);
        userPreferenceService.save(userPreference);

        return true;
    }
}
