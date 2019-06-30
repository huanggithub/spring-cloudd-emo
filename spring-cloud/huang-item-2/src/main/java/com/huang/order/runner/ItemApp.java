package com.huang.order.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * create by Mr.huang
 * 666
 * 666
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.huang.order.controller", "com.huang.order.service","com.huang.order.config"})
@EnableEurekaClient
public class ItemApp {
    public static void main(String[] args) {
        SpringApplication.run(ItemApp.class,args);
    }
}
