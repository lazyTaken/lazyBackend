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
    User getWetherAccepct(@Param("id") Integer id);  //

    @Select("update user set name=#{name} where id=#{id}")
//    public User findByUser(@Param("id")int id);
    User AlterName(@Param("id") Integer id,@Param("name") String name);
}
