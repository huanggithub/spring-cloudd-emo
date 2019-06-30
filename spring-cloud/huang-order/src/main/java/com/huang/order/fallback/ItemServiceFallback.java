package com.huang.order.fallback;

import com.huang.order.entity.Item;
import com.huang.order.feign.ItemFeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * create by Mr.huang
 * 666
 * 666
 */
@Component
public class ItemServiceFallback implements ItemFeignClient {
    @Override
    public Item queryItemById(@PathVariable("id") Long id) {
        return new Item(id,"服务降级方法queryItemById",null,null,null);
    }
}
