package com.lazytaken.lazybackend.service.impl;


import com.lazytaken.lazybackend.dao.OrderMapper;

import com.lazytaken.lazybackend.entity.Order;

import com.lazytaken.lazybackend.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Autowired
    public OrderMapper orderMapper;


    @Override
    public List<Order> getAllOrder(Integer id) {
        return orderMapper.getAllOrder(id);

    }

    @Override
    public List<Order> getAllUnhandleOrder() {
        return orderMapper.getAllUnhandleOrder();
    }

    @Override
    public List<Order> getAllUnTakenOrder(String phone) {
        return orderMapper.getAllUnTakenOrder(phone);
    }

    @Override
    public List<Order> getAllUnArrivedOrder(String phone) {
        return orderMapper.getAllUnArrivedOrder(phone);
    }

    @Override
    @Transactional
    public boolean grabOrder(String phone, String id) {
        Order order = orderMapper.getOrderById(id);
        // 如果还没有人抢到这个单子
        if (order.getStatus().equals("0")) {
            System.out.println("只有我抢到单了");
            int result = orderMapper.grabOrder(phone, id);
            if(result == 1) {
                return true;
            }
        }
        return false;
    }


}