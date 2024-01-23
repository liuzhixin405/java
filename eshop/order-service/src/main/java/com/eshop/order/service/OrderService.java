package com.eshop.order.service;


import com.eshop.order.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderService {
    Order getbyid(@Param("id") Long id);
}
