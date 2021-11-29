package com.lazytaken.lazybackend.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private String fromWhere;
    private String toWhere;
    // 包裹类型
    private String type;
    // 取件码
    private String code;
    // 订单状态
    private String status;
    private String deadline;
    private String addition;

    private String assignerId;
    private String accepterId;
    // 接单时间
    private String orderTime;
    // 送达时间
    private String arriveTime;
    // 完成时间，确认付款
    private String finishTime;
}
