package com.repository;

import com.entity.User;
import com.entity.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long>{

}
