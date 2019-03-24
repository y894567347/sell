package com.yjjpro.sell.repository;

import com.yjjpro.sell.dataobject.ProductInfo;
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
 * @Date: 2019/1/22 19:18
 * @Description:商品DAO测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
   private ProductInfoRepository productInfoRepository;
    @Test
    public void saveTest() {
        ProductInfo productInfo=new ProductInfo("123","汉堡包",new BigDecimal(10.2),100,"非常好吃的汉堡","http://hanbaoicon.com",0,1);
        productInfoRepository.save(productInfo);
    }



    @Test
    public void findByCategoryTypeTest() {
        List<ProductInfo> productInfos=productInfoRepository.findByCategoryType(1);
    }

    @Test
    public void findByProductStatusTest(){
        List<ProductInfo> productInfos=productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfos.size());
    }
}