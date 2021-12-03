package com.lazytaken.lazybackend.service.impl;


import com.lazytaken.lazybackend.dao.OrderMapper;

import com.lazytaken.lazybackend.entity.Order;

import com.lazytaken.lazybackend.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderServiceImpl implements OrderService {

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Autowired
    public OrderMapper orderMapper;


    @Override
    public Order getAllOrder(Integer id) {
        return orderMapper.getAllOrder(id);

    }


}