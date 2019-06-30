package com.huang.order.entity;

import java.io.Serializable;

/**
 * create by Mr.huang
 * 666
 * 666
 */
public class OrderDetail implements Serializable {
    private String orderId;

    private Item item = new Item();

    public OrderDetail() {

    }

    public OrderDetail(String orderId, Item item) {
        this.orderId = orderId;
        this.item = item;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderDetail [orderId=" + orderId + ", item=" + item + "]";
    }
}
