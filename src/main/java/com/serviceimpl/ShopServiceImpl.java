package com.serviceimpl;

import java.util.List;

import com.biboheart.brick.exception.BhException;
import com.biboheart.brick.utils.CheckUtils;
import com.dao.ShopDao;
import com.entity.Shop;
import com.repository.ShopRepository;
import com.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ShopDao shopDao;
    @Override
    public Shop save(Shop shop) throws BhException {
        if (null == shop.getId()) {
            throw new BhException("商户id不能为空");
        }
        shop = shopRepository.save(shop);
        return shop;
    }

    @Override
    public Shop delete(Long id) {
        if (CheckUtils.isEmpty(id)) {
            return null;
        }
        Shop shop = shopRepository.findById(id).get();
        if (null != shop) {
            shopRepository.delete(shop);
        }
        return shop;
    }

    @Override
    public Shop load(Long id) {
        if (CheckUtils.isEmpty(id)) {
            return null;
        }
        Shop shop = shopRepository.findById(id).get();
        return shop;
    }

    @Override
    public List<Shop> findAll() {
        List<Shop> allshop = shopRepository.findAll();
        return allshop;
    }
}

