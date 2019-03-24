package com.yjjpro.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.yjjpro.sell.dto.OrderDTO;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/9 11:56
 * @Description:
 */
public interface PayService {

   PayResponse create(OrderDTO orderDTO);
}
