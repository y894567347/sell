package com.yjjpro.sell.service.impl;

import com.yjjpro.sell.dataobject.ProductCategory;
import com.yjjpro.sell.repository.ProductCategoryRepository;
import com.yjjpro.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/1/17 22:09
 * @Description: 商品类目Service实现
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer CategoryId) {

        return productCategoryRepository.findById(CategoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {

        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findAllByType(List<Integer> categoryList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
