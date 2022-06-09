package com.daoimpl;

import com.dao.UserDao;
import com.entity.User;
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


    @Override
    public User checkUser(String username, String password){

        return userAuthRepository.checkUser(username,password);
    }
    public User register(String username, String password,String mail){
        User newUserAuth=new User();
        newUserAuth.setUsername(username);
        newUserAuth.setPassword(password);
        newUserAuth.setUserType(0);
        User userAuth=userAuthRepository.save(newUserAuth);
        /*Cart cart=new Cart();
        cart.setUserAuthId(userAuth.getUserId());
        userAuth.setCartId(cartRepository.save(cart).getCartId());*/
        return userAuthRepository.save(userAuth);
    }
    public User exist(String username){
        return userAuthRepository.findByUsername(username);
    }

    public List<User> getAll(){
        return userAuthRepository.findByUserType(0);
    }
}
