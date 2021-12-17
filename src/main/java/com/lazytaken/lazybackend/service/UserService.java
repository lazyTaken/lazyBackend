package com.lazytaken.lazybackend.service;

import com.lazytaken.lazybackend.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> getAllUsers();

    User AlterName(String id,String name);

    User AlterPhone(String i,String phone);

//    User AlterPhoto(String i, String photo);


    User Register(String i, String name, String password);

    User SelectByPhone(String phone);
    
    User findByPhone(String phone, String password);

    User findOnlyPhone(String phone);

    User findUserById(String id);

    boolean addUser(User user);

    int updatePassword(User user);

    User getWetherAccepct(String i);

    Map<String, String> getPayments(String phone);

    User AlterWeixin(String phone, String weixin);

    User AlterAlipay(String phone, String alipay);
}
