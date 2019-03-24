package com.yjjpro.sell.repository;

import com.yjjpro.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/1/8 17:19
 * @Description:商品类目DAO层
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    /**根据商品类目Type集合查找类目.*/
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);


}
