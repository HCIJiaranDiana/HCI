package com.controller;

import com.biboheart.brick.exception.BhException;
import com.biboheart.brick.model.BhResponseResult;
import com.entity.UserFlavor;
import com.service.UserFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserFlavorController {
    @Autowired
    private UserFlavorService userFlavorService;

    /**
     * 保存用户偏好信息
     * @param userFlavor 用户偏好信息对象
     * @return
     * @throws BhException
     */
    @RequestMapping(value = "/userflavor/save", method = {RequestMethod.POST})
    public BhResponseResult<?> register(UserFlavor userFlavor) throws BhException {
        userFlavor = userFlavorService.save(userFlavor);
        return new BhResponseResult<>(0, "success", userFlavor);
    }

    /**
     * 删除用户偏好信息
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "/userflavor/delete", method = {RequestMethod.POST, RequestMethod.GET})
    public BhResponseResult<?> delete(Long id) {
        UserFlavor userFlavor = userFlavorService.delete(id);
        return new BhResponseResult<>(0, "success", userFlavor);
    }

    /**
     * 查询用户偏好信息
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "/userflavor/load", method = {RequestMethod.POST, RequestMethod.GET})
    public BhResponseResult<?> load(Long id) {
        UserFlavor userFlavor = userFlavorService.load(id);
        return new BhResponseResult<>(0, "success", userFlavor);
    }

}
