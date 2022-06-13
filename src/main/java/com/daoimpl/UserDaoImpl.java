package com.daoimpl;

import com.dao.UserDao;
import com.entity.User;
import com.entity.UserFlavor;
import com.entity.UserPreference;
import com.repository.UserFlavorRepository;
import com.repository.UserPreferenceRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Description the implement of user dao
 * @Author thunderBoy
 * @Date 2019/11/7 13:19
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userAuthRepository;
    @Autowired
    UserFlavorRepository userFlavorRepository;
    @Autowired
    UserPreferenceRepository userPreferenceRepository;

    @Override
    public User checkUser(String username, String password){

        return userAuthRepository.checkUser(username,password);
    }
    public User register(String username, String password){
        User newUserAuth=new User();
        newUserAuth.setUsername(username);
        newUserAuth.setPassword(password);
        newUserAuth.setUserType(0);
        User userAuth=userAuthRepository.save(newUserAuth);
        UserFlavor userFlavor = new UserFlavor();
        System.out.println("userId:"+userAuth.getUserId() );
        userFlavor.setUserId(userAuth.getUserId());
        System.out.println("userId:"+userAuth.getUserId() );
        userFlavorRepository.save(userFlavor);

        UserPreference userPreference = new UserPreference();
        userPreference.setUserId(userAuth.getUserId());
        System.out.println("userId:"+userAuth.getUserId() );
        userPreferenceRepository.save(userPreference);

        return userAuthRepository.save(userAuth);
    }
    public User exist(String username){
        return userAuthRepository.findByUsername(username);
    }

    public List<User> getAll(){
        return userAuthRepository.findByUserType(0);
    }
}
