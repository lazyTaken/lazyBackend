package com.lazytaken.lazybackend.dao;

import com.lazytaken.lazybackend.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> getAllUsers();

    User findByPhone(@Param("phone")String phone, @Param("password")String password);
}
