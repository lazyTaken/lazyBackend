package com.lazytaken.lazybackend.service;

import com.lazytaken.lazybackend.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public List<User> getOnesMessageById(Integer id);
    User getWetherAccepct(Integer id);

    User AlterName(Integer id,String name);

    User AlterPhone(Integer i,String phone);

    User AlterPhoto(Integer i, String photo);

    User AlterPassword(Integer i, String password);

    User Register(Integer i, String name, String password);
}
