package com.lazytaken.lazybackend.dao;

import com.lazytaken.lazybackend.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> getAllUsers();
}
