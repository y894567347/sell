package com.yjjpro.sell.service;

import com.yjjpro.sell.dataobject.ProductInfo;
import com.yjjpro.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/26 16:02
 * @Description:商品service
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    void increaseStock(List<CartDTO> cartDTOList);

    void decreaseStock(List<CartDTO> cartDTOList);

    //取消订单加库存

    //下订单减库存
}
