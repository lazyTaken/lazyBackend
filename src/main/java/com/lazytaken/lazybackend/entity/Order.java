package com.lazytaken.lazybackend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("order")
public class Order {
    @TableId("id")
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

    public int getId() {
        return id;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public String getToWhere() {
        return toWhere;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getAddition() {
        return addition;
    }

    public String getAssignerId() {
        return assignerId;
    }

    public String getAccepterId() {
        return accepterId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public void setToWhere(String toWhere) {
        this.toWhere = toWhere;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public void setAssignerId(String assignerId) {
        this.assignerId = assignerId;
    }

    public void setAccepterId(String accepterId) {
        this.accepterId = accepterId;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
}
