package com.yjjpro.sell.enums;

import lombok.Getter;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/26 16:10
 * @Description:商品状态
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
