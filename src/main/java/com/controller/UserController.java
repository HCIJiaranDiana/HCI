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
import org.springframework.web.bind.annotation.*;

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
     * @param param 用户问卷结果
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/handlequiz")
    public boolean handlequiz(@RequestBody JSONObject param) throws BhException{
        long userid =param.getInt("id");
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
        List<Integer> list = param.getJSONArray("answers");

        float tag1 = list.get(0);
        float tag2 = list.get(1);
        float tag3 = list.get(2);
        float tag4 = list.get(3);
        float tag5 = list.get(4);
        float tag6 = list.get(5);
        float tag7 = list.get(6);
        float tag8 = list.get(7);
        float tag9 =list.get(8);
        float tag10 = list.get(9);
        float tag11 = list.get(10);
        float tag12 = list.get(11);
        float tag13 = list.get(12);
        float tag14 = list.get(13);
        float tag15 = list.get(14);
        float tag16 = list.get(15);
        float tag17 = list.get(16);
        float tag18 = list.get(17);
        float tag19 = list.get(18);
        float pospre = list.get(20);
        float pricepre =list.get(19);
        float reviewpre = list.get(21);

        userPreference.setPos_pre(pospre);
        userPreference.setPrice_pre(pricepre);
        userPreference.setReview_pre(reviewpre);
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
     * 处理用户口味外的偏好
     * @param param 用户问卷结果
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/handleprechange")
    public boolean handleprechange( @RequestBody JSONObject param) throws BhException{
        long userid =param.getInt("id");
        User user = userService.load(userid);
        List<Integer> list = param.getJSONArray("answers");

        if(user == null) {
            return false;
        }
        UserPreference userPreference = userPreferenceService.load(userid);
        if(userPreference == null) {
            return false;
        }
        float pricepre = list.get(0);
        float pospre = list.get(1);
        float reviewpre = list.get(2);

        userPreference.setPos_pre(pospre);
        userPreference.setPrice_pre(pricepre);
        userPreference.setReview_pre(reviewpre);
        userPreferenceService.save(userPreference);

        return true;
    }
    /**
     * 返回用户pre及用户名
     * @param userid 用户id
     * @return
     */
    @RequestMapping(value = "/getuserpre")
    public JSONObject getuserpre(long userid){
        User user = userService.load(userid);
        UserPreference userPreference = userPreferenceService.load(userid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",user.getUsername());
        jsonObject.put("pricepre",userPreference.getPrice_pre());
        jsonObject.put("pospre",userPreference.getPos_pre());
        jsonObject.put("reviewpre",userPreference.getReview_pre());
        return jsonObject;
    }
}
