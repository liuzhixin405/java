package com.eshop.order.mapper;

import com.eshop.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface OrderMapper {
    @Select("select * from tb_order where id=#{id}")
    Order getbyid(@Param("id") Long id);

}
