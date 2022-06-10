package com.daoimpl;

import com.dao.UserFlavorDao;
import com.repository.UserFlavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserFlavorDaoImpl implements UserFlavorDao {
    @Autowired
    UserFlavorRepository userFlavorRepository;
}
