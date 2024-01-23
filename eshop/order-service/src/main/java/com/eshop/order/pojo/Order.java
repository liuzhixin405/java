package com.eshop.order.pojo;

import lombok.Data;

@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private  Integer num;
    private  Long userId;
    private  User user;

    public Long getUserId(){
        return user.getId();
    }
}
