package com.yjjpro.sell.service;

import com.yjjpro.sell.dto.OrderDTO;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 20:21
 * @Description:
 */
public interface OrderService {
    /**创建订单.*/
    OrderDTO createOrder(OrderDTO orderDTO);

    /**查询单个订单.*/
    OrderDTO findOne(String orderId);

    /**查询订单列表.*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**取消订单 以下三个方法改变订单status.*/
    OrderDTO Cancel(OrderDTO orderDTO);

    /**支付订单.*/
    OrderDTO paid(OrderDTO orderDTO);

    /**完结订单.*/
    OrderDTO finish(OrderDTO orderDTO);
}
