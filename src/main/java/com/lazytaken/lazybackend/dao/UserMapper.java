package com.lazytaken.lazybackend.dao;

import java.util.List;


import com.lazytaken.lazybackend.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> getAllUsers();

    User findByPhone(@Param("phone")String phone, @Param("password")String password);

    User findOnlyPhone(String phone);

    @Select("select wether_accept from user where id=#{id}")
//    public User findByUser(@Param("id")int id);
    User getWetherAccepct(@Param("id") String id);

    User findUserById(String id);

    boolean addUser(User user);

    int updatePassword(User user);
//修改昵称
    @Select("update user set name=#{name} where id=#{id}")
//    public User findByUser(@Param("id")int id);
    User AlterName(@Param("id") String id,@Param("name") String name);

    @Select("update user set phone=#{phone} where id=#{id}")
    User AlterPhone(@Param("id") String i,@Param("phone") String phone);

    @Select("update user set photo=#{photo} where id=#{id}")
    User AlterPhoto(@Param("id") String i, @Param("photo") String photo);

    @Select("update user set wether_accept=1 where id=#{id}")
    User Register(@Param("id") String i, @Param("true_name") String name,@Param("reason") String reason);

    @Select("select name,photo,id,wether_accept from user where phone=#{phone}")
    User SelectByPhone(@Param("phone") String phone);
}












