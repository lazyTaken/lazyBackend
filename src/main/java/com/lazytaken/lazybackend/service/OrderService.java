package com.lazytaken.lazybackend.service;

import com.lazytaken.lazybackend.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> getAllOrder(Integer i);

    List<Order> getAllUnhandleOrder();

    List<Order> getAllUnTakenOrder(String phone);

    List<Order> getAllUnArrivedOrder(String phone);

    boolean grabOrder(String phone, String id);

    boolean pickUp(String id);

    boolean arrive(String id);

    Map<String, String> getPeopleInfo(String id);

    Order AlterAccepterID(String i, String id);
}
