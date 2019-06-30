package com.huang.order.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * create by Mr.huang
 * 666
 * 666
 */
@Component
@ConfigurationProperties(prefix = "myspcloud")
public class OrderProperties implements Serializable {
    private ItemProperties item = new ItemProperties();

    public ItemProperties getItem() {
        return item;
    }

    public void setItem(ItemProperties item) {
        this.item = item;
    }
}
