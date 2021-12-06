package com.lazytaken.lazybackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lazytaken.lazybackend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public List<User> getAllUsers();
    public List<User> getOnesMessageById(Integer id);


    @Select("select wether_accept from user where id=#{id}")
//    public User findByUser(@Param("id")int id);
    User getWetherAccepct(@Param("id") Integer id);

//修改昵称
    @Select("update user set name=#{name} where id=#{id}")
//    public User findByUser(@Param("id")int id);
    User AlterName(@Param("id") Integer id,@Param("name") String name);

    @Select("update user set phone=#{phone} where id=#{id}")
    User AlterPhone(@Param("id") Integer i,@Param("phone") String phone);

    @Select("update user set photo=#{photo} where id=#{id}")
    User AlterPhoto(@Param("id") Integer i, @Param("photo") String photo);

    @Select("update user set password=#{password} where id=#{id}")
    User AlterPassword(@Param("id") Integer i,@Param("password") String password);

    @Select("update user set wether_accept=1 where id=#{id}")
    User Register(@Param("id") Integer i, @Param("true_name") String name,@Param("reason") String reason);

    @Select("select name,photo,id,wether_accept from user where phone=#{phone}")
    User SelectByPhone(@Param("phone") String phone);
}












