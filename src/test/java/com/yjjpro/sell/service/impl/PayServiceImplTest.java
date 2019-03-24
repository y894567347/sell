package com.yjjpro.sell.service.impl;

import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.yjjpro.sell.dto.OrderDTO;
import com.yjjpro.sell.service.OrderService;
import com.yjjpro.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/9 15:31
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;
    @Test
    public void create() {

        OrderDTO orderDTO = orderService.findOne("1551534157871422463");
        payService.create(orderDTO);
    }
}