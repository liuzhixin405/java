package com.eshop.order.service;

import com.eshop.order.clients.UserClient;
import com.eshop.order.mapper.OrderMapper;
import com.eshop.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.eshop.order.pojo.User;
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orm;
    @Autowired
    private UserClient userClient;
    @Override
    public Order getbyid(Long id) {

        Order order = orm.getbyid(id);
        User user=userClient.getUserById(order.getUserId());
        return order;
    }
}
