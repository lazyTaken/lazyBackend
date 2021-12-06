package com.lazytaken.lazybackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String fromWhere;
    private String toWhere;
    // 包裹类型
    private String type;
    // 取件码
    private String code;
    // 订单状态
    private String status;
    private String addition;

    private String assignerId;
    private String accepterId;
    // 下单时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp orderTime;
    // 接单时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp robTime;
    // 取件时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp takenTime;
    // 送达时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp arriveTime;
    // 完成时间，确认付款
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp finishTime;
    //截止时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp deadline;

    private int version;
}
