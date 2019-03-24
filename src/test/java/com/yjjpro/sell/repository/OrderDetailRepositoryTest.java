package com.yjjpro.sell.repository;

import com.yjjpro.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 19:55
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void save(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("0002");
        orderDetail.setOrderId("1234567");
        orderDetail.setProductName("鸡肉卷");
        orderDetail.setProductIcon("http://xxxxx.com");
        orderDetail.setProductPrice(new BigDecimal(9.2));
        orderDetail.setProductQuantity(3);
        orderDetail.setProductId("123123");
        orderDetailRepository.save(orderDetail);
        Assert.assertNotEquals(null,orderDetail);

    }

    @Test
    public void findByOpenid(){
        List<OrderDetail> orderDetailList=orderDetailRepository.findByOrderId("123456");
        Assert.assertNotEquals(0,orderDetailList);

    }
}