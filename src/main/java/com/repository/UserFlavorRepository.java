package com.repository;

import com.entity.User;
import com.entity.UserFlavor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface UserFlavorRepository extends JpaRepository<UserFlavor, Long> {
}
