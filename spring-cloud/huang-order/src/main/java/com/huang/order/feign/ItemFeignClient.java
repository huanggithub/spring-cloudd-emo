package com.huang.order.feign;

import com.huang.order.entity.Item;
import com.huang.order.fallback.ItemServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * create by Mr.huang
 * 666
 * 666
 */
@FeignClient(value = "app-item",fallback = ItemServiceFallback.class)
public interface ItemFeignClient {
    @RequestMapping(value = "/item/{id}",method = RequestMethod.GET)
    Item queryItemById(@PathVariable("id") Long id);
}
