package com.serviceimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
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
        if (null == userFlavor.getUserId()) {
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

    @Override
    public List<Float> getTagWeigh(Long id){
        UserFlavor userFlavor = userFlavorRepository.findById(id).get();
        if (userFlavor == null) {
            return null;
        }
        float f = 0.0f;
        float w = 0.0f;
        BigDecimal b = new BigDecimal(String.valueOf(f));
        double d = b.doubleValue();
        List<Float> tagWeigh = new ArrayList<>();
        f = userFlavor.getTag1();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag2();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag3();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag4();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag5();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag6();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag7();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag8();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag9();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag10();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag11();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag12();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag13();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag14();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag15();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag16();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag17();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag18();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        f = userFlavor.getTag19();
        w = turnFlavorIntoWeigh(f);
        tagWeigh.add(w);
        System.out.println(tagWeigh);
        return tagWeigh;
    }

    @Override
    public float turnFlavorIntoWeigh(float f){
        BigDecimal b;
        double d ;
        if(f < 0 ){
            b = new BigDecimal(String.valueOf(f));
            d = b.doubleValue();
            return (float)Math.exp(d);
        }
        else {
            f = 10.0f - (9.0f / (f / 3.0f + 1.0f));
            return f;
        }
    }

}
