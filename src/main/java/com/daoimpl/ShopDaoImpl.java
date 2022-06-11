package com.daoimpl;

import com.dao.ShopDao;
import com.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoImpl implements ShopDao {
    @Autowired
    ShopRepository shopRepository;
}