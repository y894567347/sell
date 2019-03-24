package com.yjjpro.sell.dto;

import lombok.Data;
import lombok.Getter;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 22:07
 * @Description:购物车  从前端传回来的对象只有两个字段
 */
@Data
public class CartDTO {
    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
