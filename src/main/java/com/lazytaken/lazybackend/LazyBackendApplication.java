package com.lazytaken.lazybackend;

import com.lazytaken.lazybackend.dao.UserMapper;
import com.lazytaken.lazybackend.entity.User;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

@SpringBootApplication
@MapperScan("com.lazytaken.lazybackend.dao")
public class LazyBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(LazyBackendApplication.class, args);

    }



}
