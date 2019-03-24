package com.yjjpro.sell.service.impl;

import com.yjjpro.sell.dto.OrderDTO;
import com.yjjpro.sell.enums.ResultEnum;
import com.yjjpro.sell.exception.SellException;
import com.yjjpro.sell.service.BuyerService;
import com.yjjpro.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/4 20:50
 * @Description:
 */
@Slf4j
@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    private OrderDTO checkOrderOwner(String openid,String orderId){
        OrderDTO orderDTO = orderService.findOne(openid);
        if(!orderDTO.getBuyerOpenid().equals(openid)){
            log.error("【买家查询订单】 与订单的openid不一致 openid={} orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);

        }
        return orderDTO;
    }

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {

        OrderDTO orderDTO = checkOrderOwner(openid,orderId);
        if(orderDTO == null){
            log.error("【取消订单】  订单不存在 orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.Cancel(orderDTO);
    }
}
