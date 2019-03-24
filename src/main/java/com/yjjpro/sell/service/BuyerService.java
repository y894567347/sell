package com.yjjpro.sell.service;

import com.yjjpro.sell.dto.OrderDTO;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/4 20:48
 * @Description:
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
