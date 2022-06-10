package com.serviceimpl;

import java.util.List;

import com.biboheart.brick.exception.BhException;
import com.biboheart.brick.utils.CheckUtils;
import com.biboheart.brick.utils.TimeUtils;
import com.dao.UserPreferenceDao;
import com.entity.UserPreference;
import com.repository.UserPreferenceRepository;
import com.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UserPreferenceServiceImpl implements UserPreferenceService {
    @Autowired
    private UserPreferenceRepository userPreferenceRepository;
    @Autowired
    private UserPreferenceDao userPreferenceDao;
    @Override
    public UserPreference save(UserPreference userPreference) throws BhException {
        if (null == userPreference.getId()) {
            throw new BhException("用户id不能为空");
        }
        userPreference = userPreferenceRepository.save(userPreference);
        return userPreference;
    }

    @Override
    public UserPreference delete(Long id) {
        if (CheckUtils.isEmpty(id)) {
            return null;
        }
        UserPreference userPreference = userPreferenceRepository.findById(id).get();
        if (null != userPreference) {
            userPreferenceRepository.delete(userPreference);
        }
        return userPreference;
    }

    @Override
    public UserPreference load(Long id) {
        if (CheckUtils.isEmpty(id)) {
            return null;
        }
        UserPreference userPreference = userPreferenceRepository.findById(id).get();
        return userPreference;
    }
}