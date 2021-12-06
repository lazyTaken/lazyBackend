package com.lazytaken.lazybackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.junit.Test;
import java.io.Serializable;
@SpringBootApplication
@MapperScan("com.lazytaken.lazybackend.dao")
public class LazyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazyBackendApplication.class, args);
    }

}