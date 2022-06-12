package com.service;

import java.util.List;

import com.biboheart.brick.exception.BhException;
import com.entity.Shop;
import com.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface ShopService {
    /**
     * 保存商户信息
     *
     * @param shop
     *            商户信息对象
     * @return 保存成功后的商户信息或null
     */
    public Shop save(Shop  shop ) throws BhException;


    /**
     * 删除商户信息
     *
     * @param id
     *            商户ID
     * @return 返回删除成功的商户信息或null
     */
    public Shop delete(Long id);

    /**
     * 查询用户偏好信息
     *
     * @param id
     *            商户ID
     * @return 商户信息或null
     */
    public Shop load(Long id);

    public List<Shop> findAll();

    public List<Shop> findByShopType(String shoptype);
}
