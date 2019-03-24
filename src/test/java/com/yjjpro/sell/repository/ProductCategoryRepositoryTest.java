package com.yjjpro.sell.repository;

import com.yjjpro.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/1/8 17:21
 * @Description:商品类目DAO测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Test
    public void findoneTest() {
        ProductCategory productCategory=productCategoryRepository.findById(1).get();
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveOneTest() {

    }
    @Test
    public void findByCategoryType() {
        List<Integer> list= Arrays.asList(2,3,4);

        List<ProductCategory> productCategoryList=productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,productCategoryList.size());
    }

}