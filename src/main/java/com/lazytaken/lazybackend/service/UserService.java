package com.lazytaken.lazybackend.service;

import com.lazytaken.lazybackend.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    User findByPhone(String phone, String password);

    User findOnlyPhone(String phone);

    User findUserById(String id);

    boolean addUser(User user);

    int updatePassword(User user);
}
