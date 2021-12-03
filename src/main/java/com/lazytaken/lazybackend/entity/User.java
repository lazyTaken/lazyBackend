package com.lazytaken.lazybackend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    // 可以是学号或教职工编号
    @TableId("id")
    private int id;
    private String name;
    private String password;
    // 是否有接单者身份
    private String wetherAccept;
    private String photo;
    private String phone;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWetherAccept(String wetherAccept) {
        this.wetherAccept = wetherAccept;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getWetherAccept() {
        return wetherAccept;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPhone() {
        return phone;
    }
}
