package com.lazytaken.lazybackend.controller;
import com.lazytaken.lazybackend.entity.Order;
import com.lazytaken.lazybackend.service.OrderService;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.*;
import com.lazytaken.lazybackend.dao.OrderMapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@MapperScan("com.baomidou.ant.sys.mapper")
@RequestMapping("/order")
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
    @RequestMapping(value="/alterAssignerID",method= RequestMethod.GET)
    public Map<String, Object> AlterAccepterID(@RequestParam("assigner_id") String i,@RequestParam("id") Integer id) {
        System.out.println("username is:"+i);
        Order order = orderService.AlterAccepterID(i,id);
        Map<String, Object> map = new HashMap<>(3);
        map.put("staCode",1);
        map.put("success",1);
        return map;
        }
    private OrderMapper orderMapper;
    //测试乐观锁
    @Autowired
    private OrderService service;
    @RequestMapping(value="/lock",method= RequestMethod.GET)
    public void lock(@RequestParam("id") String id){
        Order byId = orderMapper.selectById(id);
        Order order = new Order();
        order.setId(id);
        int i ;
        for (i=0;i<50;i++) {
        order.setFromWhere(byId.getFromWhere()+1);
        order.setVersion(byId.getVersion());
        int b = orderMapper.updateById(order);
        }
//获得订单
    @PostMapping("getOrder")
    public String getList(@RequestBody Order order){
        orderMapper.insert(order);
        return "success";
    }
}
