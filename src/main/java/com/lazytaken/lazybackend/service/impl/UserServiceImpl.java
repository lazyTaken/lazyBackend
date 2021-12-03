package com.lazytaken.lazybackend.service.impl;

import com.lazytaken.lazybackend.dao.UserMapper;
import com.lazytaken.lazybackend.entity.User;
import com.lazytaken.lazybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public List<User> getOnesMessageById(Integer id) {
        return userMapper.getOnesMessageById(id);
    }

    @Override
    public User getWetherAccepct(Integer id) {
        return userMapper.getWetherAccepct(id);

    }

    @Override
    public User AlterName(Integer id,String name) {
        return userMapper.AlterName(id,name);
    }

    @Override
    public User AlterPhone(Integer i,String phone) {
        return userMapper.AlterPhone(i,phone);
    }

    @Override
    public User AlterPhoto(Integer i, String photo) {
        return userMapper.AlterPhoto(i,photo);
    }


}
