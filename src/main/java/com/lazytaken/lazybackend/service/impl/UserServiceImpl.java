package com.lazytaken.lazybackend.service.impl;

import com.lazytaken.lazybackend.dao.UserMapper;
import com.lazytaken.lazybackend.entity.User;
import com.lazytaken.lazybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public User findByPhone(String phone, String password) {
        return userMapper.findByPhone(phone, password);
    }
}
