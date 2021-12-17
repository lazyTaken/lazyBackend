package com.lazytaken.lazybackend.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lazytaken.lazybackend.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Repository
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select * from `order` where assigner_id=#{assigner_id}")
    List<Order> getAllOrder(@Param("assigner_id") String id);
    @Update("update `order` set assigner_id=#{assigner_id} where id=#{id}")
    Order AlterAccepterID(@Param("assigner_id") String i,@Param("id") Integer id);
    List<Order> getAllUnhandleOrder();

    List<Order> getAllOrder(@Param("assigner_id") Integer id);
    int updateOrderArrived(Order order);
    int updateOrderTaken(Order order);
    Order getOrderById(String id);
    int grabOrder(String phone, String id);
    List<Order> getAllUnArrivedOrder(String phone);
    List<Order> getAllUnTakenOrder(String phone);
}
