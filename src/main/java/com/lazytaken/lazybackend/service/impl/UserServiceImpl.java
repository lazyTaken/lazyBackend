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
    public User AlterName(String id, String name) {
        return userMapper.AlterName(id,name);
    }

    @Override
    public User findByPhone(String phone, String password) {
        return userMapper.findByPhone(phone, password);
    }

    @Override
    public User findOnlyPhone(String phone) {
        return userMapper.findOnlyPhone(phone);
    }

    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updatePassword(User user) {
        return userMapper.updatePassword(user);
    }

    @Override
    public User getWetherAccepct(String i) {
        return userMapper.getWetherAccepct(i);
    }

    @Override
    public User AlterPhone(String i,String phone) {
        return userMapper.AlterPhone(i,phone);
    }

    @Override
    public User AlterPhoto(String i, String photo) {
        return userMapper.AlterPhoto(i,photo);
    }

//    @Override
//    public User AlterPassword(Integer i, String password) {
//        return userMapper.AlterPassword(i,password);
//    }

    @Override
    public User Register(String i, String name, String password) {
        return userMapper.Register(i,name,password);
    }

    @Override
    public User SelectByPhone(String phone) {
        return userMapper.SelectByPhone(phone);
    }


}
