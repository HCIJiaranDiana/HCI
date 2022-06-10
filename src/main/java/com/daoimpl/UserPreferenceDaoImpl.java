package com.daoimpl;

import com.dao.UserPreferenceDao;
import com.entity.UserPreference;
import com.repository.UserPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserPreferenceDaoImpl implements UserPreferenceDao {

    @Autowired
    UserPreferenceRepository userPreferenceRepository;


}
