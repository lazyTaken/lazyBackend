package com.lazytaken.lazybackend.dao;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lazytaken.lazybackend.entity.Order;
import com.lazytaken.lazybackend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper  extends BaseMapper<User> {
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
    User AlterName(@Param("id") String id,@Param("name") String name);

    @Select("update user set phone=#{phone} where id=#{id}")
    User AlterPhone(@Param("id") String i,@Param("phone") String phone);

    @Select("update user set weixin=#{weixin} where phone=#{phone}")
    User AlterWeixin(@Param("phone") String phone, @Param("weixin") String weixin);

    @Select("update user set alipay=#{alipay} where phone=#{phone}")
    User AlterAlipay(@Param("phone") String phone, @Param("alipay") String alipay);
    @Select("update user set wether_accept=1 where id=#{id}")
    User Register(@Param("id") String i, @Param("true_name") String name,@Param("reason") String reason);

    @Select("select name,id,wether_accept,weixin,alipay from user where phone=#{phone}")
    User SelectByPhone(@Param("phone") String phone);
}












