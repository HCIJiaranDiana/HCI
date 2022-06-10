package com.controller;

import com.biboheart.brick.exception.BhException;
import com.biboheart.brick.model.BhResponseResult;
import com.entity.UserPreference;
import com.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserPreferenceController {
    @Autowired
    private UserPreferenceService userPreferenceService;

    /**
     * 保存用户偏好信息
     * @param userPreference 用户偏好信息对象
     * @return
     * @throws BhException
     */
    @RequestMapping(value = "/userpreference/save", method = {RequestMethod.POST})
    public BhResponseResult<?> register(UserPreference userPreference) throws BhException {
        userPreference = userPreferenceService.save(userPreference);
        return new BhResponseResult<>(0, "success", userPreference);
    }

    /**
     * 删除用户偏好信息
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "/userpreference/delete", method = {RequestMethod.POST, RequestMethod.GET})
    public BhResponseResult<?> delete(Long id) {
        UserPreference userPreference = userPreferenceService.delete(id);
        return new BhResponseResult<>(0, "success", userPreference);
    }

    /**
     * 查询用户偏好信息
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "/userpreference/load", method = {RequestMethod.POST, RequestMethod.GET})
    public BhResponseResult<?> load(Long id) {
        UserPreference userPreference = userPreferenceService.load(id);
        return new BhResponseResult<>(0, "success", userPreference);
    }

}
