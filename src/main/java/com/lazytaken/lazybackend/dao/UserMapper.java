package com.lazytaken.lazybackend.dao;

import com.lazytaken.lazybackend.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> getAllUsers();

    User findByPhone(@Param("phone")String phone, @Param("password")String password);

    User findOnlyPhone(String phone);

    User findUserById(String id);

    boolean addUser(User user);

    int updatePassword(User user);
}
