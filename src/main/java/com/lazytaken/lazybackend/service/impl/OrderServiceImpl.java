package com.lazytaken.lazybackend.service.impl;


import com.lazytaken.lazybackend.dao.OrderMapper;

import com.lazytaken.lazybackend.dao.UserMapper;
import com.lazytaken.lazybackend.entity.Order;

import com.lazytaken.lazybackend.entity.User;
import com.lazytaken.lazybackend.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;


    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

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
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean pickUp(String id) {
        Order order = orderMapper.getOrderById(id);
        if(order.getStatus().equals("1")) {
            order.setStatus("2");
            int result = orderMapper.updateOrderTaken(order);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean arrive(String id) {
        Order order = orderMapper.getOrderById(id);
        if(order.getStatus().equals("2")) {
            order.setStatus("3");
            int result = orderMapper.updateOrderArrived(order);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<String, String> getPeopleInfo(String id) {
        Order order = orderMapper.getOrderById(id);
        Map<String, String> res = new HashMap<>();
        User assigner = userMapper.findUserById(order.getAssignerId());
        res.put("assignerName", assigner.getName());
        res.put("assignerPhone", assigner.getPhone());
        if (order.getAccepterId() == null) {
            res.put("accepterName", "");
            res.put("accepterPhone", "");
        } else {
            User accepter = userMapper.findUserById(order.getAccepterId());
            res.put("accepterName", accepter.getName());
            res.put("accepterPhone", accepter.getPhone());
        }
        return res;
    }

    @Override
    public Order AlterAccepterID(String i, String id) {
        return orderMapper.AlterAccepterID(i,id);
    }


}