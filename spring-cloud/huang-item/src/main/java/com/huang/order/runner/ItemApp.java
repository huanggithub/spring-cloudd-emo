package com.huang.order.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by Mr.huang
 * 666
 * 666
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.huang.order.controller", "com.huang.order.service","com.huang.order.config"})
@EnableEurekaClient
//@RestController
public class ItemApp {

//    @Value("${jdbc.url}")
//    private String url;
//    @Value("${jdbc.username}")
//    private String username;
//    @Value("${jdbc.password}")
//    private String password;
//    @Value("${jdbc.driverClassName}")
//    private String driverClassName;

    public static void main(String[] args) {
        SpringApplication.run(ItemApp.class,args);
    }

//    @RequestMapping(value = "/hi")
//    public String hi(){
//        return url+username+password+driverClassName;
//    }

}
