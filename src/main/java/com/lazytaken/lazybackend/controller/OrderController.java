package com.lazytaken.lazybackend.controller;
import com.lazytaken.lazybackend.dao.UserMapper;
import com.lazytaken.lazybackend.entity.Order;

import com.lazytaken.lazybackend.service.OrderService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.lazytaken.lazybackend.dao.OrderMapper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@MapperScan("com.baomidou.ant.sys.mapper")
public class OrderController {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;
    //    @GetMapping("/user/{id}")
    @RequestMapping(value="/order",method= RequestMethod.GET)
    public List<Order> getAllOrder(@RequestParam("id") int i) {
        System.out.println("username is:"+i);
        Order order = orderService.getAllOrder(i);
        List<Order> orderList= new ArrayList<Order>();
        orderList.add(order);
////        userMapper.insert(u);
        return orderList;
    }
}
