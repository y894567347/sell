package com.yjjpro.sell.service.impl;

import com.yjjpro.sell.dataobject.OrderDetail;
import com.yjjpro.sell.dataobject.OrderMaster;
import com.yjjpro.sell.dto.OrderDTO;
import com.yjjpro.sell.enums.OrderStatusEnum;
import com.yjjpro.sell.enums.PayStatusEnum;
import com.yjjpro.sell.repository.OrderMasterRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/28 10:55
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void createOrder() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("杨俊杰");
        orderDTO.setBuyerAddress("长沙理工大学");
        orderDTO.setBuyerPhone("13142264905");
        orderDTO.setBuyerOpenid("BUYER_OPENID");

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("125");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("111");
        o2.setProductQuantity(2);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.createOrder(orderDTO);
        Assert.assertNotNull(result);
        log.info("【创建订单】 result={}",result );

    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne("1551332943864743522");
        log.info("【查找订单】 result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findList() {

        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> orderMasterPage = orderService.findList("BUYER_OPENID",request);
        Assert.assertNotEquals(0,orderMasterPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne("1551332943864743522");
        OrderDTO result = orderService.Cancel(orderDTO);
        Assert.assertNotEquals(OrderStatusEnum.CANCEL,result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1551332943864743522");
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertNotEquals(PayStatusEnum.SUCCESS,result.getPayStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne("1551332943864743522");
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertNotEquals(OrderStatusEnum.FINISHED,result.getOrderStatus());
    }
}