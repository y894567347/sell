package com.yjjpro.sell.service;

import com.yjjpro.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/1/17 22:05
 * @Description:商品类目Service
 */
public interface CategoryService {
    ProductCategory findOne(Integer CategoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findAllByType(List<Integer> categoryList);

    ProductCategory save(ProductCategory productCategory);

}
