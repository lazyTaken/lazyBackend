package com.lazytaken.lazybackend.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // 可以是学号或教职工编号
    private int id;
    private String name;
    private String password;
    // 是否有接单者身份
    private String wetherAccept;
    private String photo;
    private String phone;
}
