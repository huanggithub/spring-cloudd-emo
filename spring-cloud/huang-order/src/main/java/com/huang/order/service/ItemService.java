package com.huang.order.service;

import com.huang.order.entity.Item;
import com.huang.order.feign.ItemFeignClient;
import com.huang.order.properties.OrderProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * create by Mr.huang
 * 666
 * 666
 */
@Service
public class ItemService {
    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ItemFeignClient itemFeignClient;
//    @Value("${myspcloud.item.url}")
//    private String itemUrl;
    @Autowired
    OrderProperties orderProperties;
//    @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")
    public Item queryItemById(Long id) {
//        return this.restTemplate.getForObject(orderProperties.getItem().getUrl()
//                + id, Item.class);

        // 该方法走eureka注册中心调用(去注册中心根据app-item查找服务，这种方式必须先开启负载均衡@LoadBalanced)
        String itemUrl = "http://app-item/item/{id}";
        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        System.out.println("===========HystrixCommand queryItemById-线程池名称：" + Thread.currentThread().getName() + "订单系统调用商品服务,result:" + result);
//        System.out.println("订单系统调用商品服务,result:" + result);
        return result;
    }
//    @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")
    public Item queryItemById3(Long id) {
//        return this.restTemplate.getForObject(orderProperties.getItem().getUrl()
//                + id, Item.class);

        // 该方法走eureka注册中心调用(去注册中心根据app-item查找服务，这种方式必须先开启负载均衡@LoadBalanced)
        String itemUrl = "http://app-item/item/{id}";
//        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        Item result = itemFeignClient.queryItemById(id);
        System.out.println("===========HystrixCommand queryItemById-线程池名称：" + Thread.currentThread().getName() + "订单系统调用商品服务,result:" + result);
//        System.out.println("订单系统调用商品服务,result:" + result);
        return result;
    }
//    public Item queryItemByIdFallbackMethod(Long id){
//        return new Item(id,"查询商品出错",null,null,null);
//    }
}
