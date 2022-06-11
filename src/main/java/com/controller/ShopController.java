package com.controller;

import com.constant.Constant;
import com.entity.Shop;
import com.entity.User;
import com.service.CallCountService;
import com.service.ShopService;
import com.service.UserService;
import com.utils.CallCount.Add;
import com.utils.msgutils.Msg;

import com.utils.msgutils.MsgCode;
import com.utils.msgutils.MsgUtil;
import com.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;
    /**
     * 计算用户和商户距离
     * @param posx 用户当前经度
     * @param posy 用户当前纬度
     * @param shop_id 商户id
     * @return
     */


    @RequestMapping(value = "/caldistance", method = {RequestMethod.POST},produces = {"application/json;charset=UTF-8"})
    public Shop caldistance(double posx,double posy,Long shop_id) {
        Shop shop = shopService.load(shop_id);
        System.out.print("double:"+posx);
        System.out.print("double:"+posy);
        float me_posx = (float)posx;
        float me_posy = (float)posy;
        float shop_posx = shop.getPosx();
        float shop_posy = shop.getPosy();
        float res = Math.abs(shop_posx - me_posx)+Math.abs(shop_posy-me_posy);

        System.out.print("shop:"+shop);
        return shop;
    }
    @ResponseBody
    @RequestMapping(value = "/caldistancejson", method = {RequestMethod.POST},produces = {"application/json;charset=UTF-8"})
    public float caldistance(@RequestBody JSONObject param) {
        float posx = Float.parseFloat(param.getString("poxx"));
        float posy = Float.parseFloat(param.getString("poxy"));
        Long shop_id = param.getLong("shop_id");
        Shop shop = shopService.load(shop_id);
        float shop_posx = shop.getPosx();
        float shop_posy = shop.getPosy();
        float res = Math.abs(shop_posx - posx)+Math.abs(shop_posy-posy);
        return res;
    }


}
