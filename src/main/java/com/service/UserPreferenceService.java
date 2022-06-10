package com.service;

import java.util.List;

import com.biboheart.brick.exception.BhException;
import com.entity.UserPreference;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface UserPreferenceService {
    /**
     * 保存用户偏好信息，不包括口味
     *
     * @param userPreference
     *            用户信息对象
     * @return 保存成功后的用户偏好信息或null
     */
    public UserPreference save(UserPreference  userPreference ) throws BhException;


    /**
     * 删除用户偏好信息
     *
     * @param id
     *            用户ID
     * @return 返回删除成功的用户偏好信息或null
     */
    public UserPreference delete(Long id);

    /**
     * 查询用户偏好信息
     *
     * @param id
     *            用户ID
     * @return 用户偏好信息或null
     */
    public UserPreference load(Long id);
}
