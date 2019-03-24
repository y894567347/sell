package com.yjjpro.sell.repository;

import com.yjjpro.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/1/22 19:17
 * @Description:商品DAO层
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByCategoryType(Integer categoryType);

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
