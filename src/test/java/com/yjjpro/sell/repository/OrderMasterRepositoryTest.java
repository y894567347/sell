package com.yjjpro.sell.repository;

import com.yjjpro.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 19:24
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    private final String OPENID="1111";
    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("王女士");
        orderMaster.setBuyerPhone("13343264905");
        orderMaster.setBuyerAddress("长沙理工大学");
        orderMaster.setBuyerOpenid("19382757");
        orderMaster.setOrderAmount(new BigDecimal(25.3));
        orderMasterRepository.save(orderMaster);
        Assert.assertNotEquals(null,orderMaster);

    }

    @Test
    public void findByBuyerOpenid(){
        PageRequest request=PageRequest.of(0,3);
        Page<OrderMaster> orderMasterPage=orderMasterRepository.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,orderMasterPage.getTotalElements());
    }

    @Test
    public void findOneTest(){
        String id="1551332943864743522";
        OrderMaster orderMaster=orderMasterRepository.findById(id).get();
        Assert.assertNotNull(orderMaster);
    }
}