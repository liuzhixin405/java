package com.eshop.order.controller;

import com.eshop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  com.eshop.order.pojo.Order;
@RestController
@RequestMapping("/order")

public class OrderController {

    @Autowired
    private OrderService os;
    @GetMapping("/{orderId}")
    public  Order getById(@PathVariable Long orderId){

        Order order =  os.getbyid(orderId);
        return order;
    }

    @RequestMapping("/test")
    public  String TestController(){

        return "ok";
    }
}
