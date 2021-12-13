package com.lazytaken.lazybackend.controller;
import com.lazytaken.lazybackend.entity.Order;
import com.lazytaken.lazybackend.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
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

    // 返回所有未接订单
    @GetMapping("/order/unHandleOrders")
    public ResponseEntity<List<Order>> getAllUnhandingOrders() throws IOException {
        List<Order> res = orderService.getAllUnhandleOrder();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // 接单者还未取件的单子
    @GetMapping("/order/unTakenOrders")
    public ResponseEntity<List<Order>> getAllUnTakenOrders(String phone) throws IOException {
        List<Order> res = orderService.getAllUnTakenOrder(phone);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // 取件但还未送达的订单
    @GetMapping("/order/unArrivedOrders")
    public ResponseEntity<List<Order>> getAllUnArrivedOrders(String phone) throws IOException {
        List<Order> res = orderService.getAllUnArrivedOrder(phone);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // 抢单，加悲观锁
    @GetMapping("/order/grabOrder")
    public ResponseEntity<Boolean> grabOrder(String phone, String id) throws IOException {
        boolean res = orderService.grabOrder(phone, id);
        if (res) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
        }
    }

    // 取件
    @GetMapping("/order/pickup")
    public ResponseEntity<Boolean> pickUp(String id) throws IOException {
        boolean res = orderService.pickUp(id);
        if(res) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
        }
    }

    // 送达
    @GetMapping("/order/arrive")
    public ResponseEntity<Boolean> arrive(String id) throws IOException {
        boolean res = orderService.arrive(id);
        if(res) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
        }
    }

    // 获取发单，接单人信息
    @GetMapping("/order/peopleInfo")
    public ResponseEntity<Object> getPeopleInfo(String id) throws IOException {
        Map<String, String> res = orderService.getPeopleInfo(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
 }
