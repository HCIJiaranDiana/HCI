package com.serviceimpl;

import java.util.List;

import com.biboheart.brick.exception.BhException;
import com.biboheart.brick.utils.CheckUtils;
import com.biboheart.brick.utils.TimeUtils;
import com.dao.UserFlavorDao;
import com.dao.UserPreferenceDao;
import com.entity.UserFlavor;
import com.entity.UserPreference;
import com.repository.UserFlavorRepository;
import com.repository.UserPreferenceRepository;
import com.service.UserFlavorService;
import com.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserFlavorServiceImpl implements UserFlavorService {
    @Autowired
    private UserFlavorRepository userFlavorRepository;
    @Autowired
    private UserFlavorDao userFlavorDao;
    @Override
    public UserFlavor save(UserFlavor userFlavor) throws BhException {
        if (null == userFlavor.getId()) {
            throw new BhException("用户id不能为空");
        }
        userFlavor = userFlavorRepository.save(userFlavor);
        return userFlavor;
    }

    @Override
    public UserFlavor delete(Long id) {
        if (CheckUtils.isEmpty(id)) {
            return null;
        }
        UserFlavor userFlavor = userFlavorRepository.findById(id).get();
        if (null != userFlavor) {
            userFlavorRepository.delete(userFlavor);
        }
        return userFlavor;
    }

    @Override
    public UserFlavor load(Long id) {
        if (CheckUtils.isEmpty(id)) {
            return null;
        }
        UserFlavor userFlavor = userFlavorRepository.findById(id).get();
        return userFlavor;
    }
}
