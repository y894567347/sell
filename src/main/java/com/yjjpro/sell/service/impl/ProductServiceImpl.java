package com.yjjpro.sell.service.impl;

import com.yjjpro.sell.dataobject.ProductInfo;
import com.yjjpro.sell.dto.CartDTO;
import com.yjjpro.sell.dto.OrderDTO;
import com.yjjpro.sell.enums.ProductStatusEnum;
import com.yjjpro.sell.enums.ResultEnum;
import com.yjjpro.sell.exception.SellException;
import com.yjjpro.sell.repository.ProductInfoRepository;
import com.yjjpro.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/26 16:07
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {

        for(CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = findOne(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result=productInfo.getProductStock()+cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            this.save(productInfo);

        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
    for(CartDTO cartDTO : cartDTOList){
        ProductInfo productInfo=this.findOne(cartDTO.getProductId());
        if(productInfo==null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        Integer result=productInfo.getProductStock()-cartDTO.getProductQuantity();
        if(result<0){
            throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
        }
        productInfo.setProductStock(result);
        productInfoRepository.save(productInfo);
    }
    }
}

