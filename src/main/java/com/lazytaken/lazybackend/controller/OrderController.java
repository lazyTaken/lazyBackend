package com.lazytaken.lazybackend.controller;
import com.lazytaken.lazybackend.entity.Order;
import com.lazytaken.lazybackend.service.OrderService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lazytaken.lazybackend.dao.OrderMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;
    //    @GetMapping("/user/{id}")
    @RequestMapping(value="/getAllOrder",method= RequestMethod.GET)
    public Map<String, Object> getAllOrder(@RequestParam("assigner_id") int i) {
        System.out.println("username is:"+i);
        List<Order> orderList= new ArrayList<Order>();
        orderList = orderService.getAllOrder(i);

//        orderList.add(order);
        Map<String, Object> map = new HashMap<>(3);
        map.put("order",orderList.toArray());

        map.put("staCode",1);
//        map.put("success",1);
        return map;
    }
}
