package com.huang.order.controller;

import com.huang.order.config.JdbcConfigBean;
import com.huang.order.entity.Item;
import com.huang.order.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by Mr.huang
 * 666
 * 666
 */
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Value("${server.port}")
    private String port;
    @Autowired
    private JdbcConfigBean jdbcConfigBean;
    /**
     * 对外提供接口服务，查询商品信息
     *
     * @param id
     * @return
     */
    @GetMapping("item/{id}")
    public Item queryItemById(@PathVariable("id") Long id){
        System.out.println(port);
        return itemService.queryItemById(id);
    }

    @GetMapping(value = "testconfig")
    public String testconfig(){
        return this.jdbcConfigBean.toString();
    }

}
