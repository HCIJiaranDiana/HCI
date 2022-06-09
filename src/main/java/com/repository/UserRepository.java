package com.repository;


import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
    @Query(value = "from User where username = :username and password = :password")
    User checkUser(@Param("username") String username, @Param("password") String password);

    User findByUsername(String username);

    List<User> findByUserType(int userType);
}