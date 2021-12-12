package com.lazytaken.lazybackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lazytaken.lazybackend.entity.Order;
import com.lazytaken.lazybackend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
@Mapper
public interface OrderMapper extends BaseMapper<User> {

    @Select("select * from `order` where assigner_id=#{assigner_id}")
    List<Order> getAllOrder(@Param("assigner_id") Integer id);

    List<Order> getAllUnhandleOrder();

    List<Order> getAllUnTakenOrder(String phone);

    List<Order> getAllUnArrivedOrder(String phone);

    Order getOrderById(String id);

    int grabOrder(String phone, String id);
}
