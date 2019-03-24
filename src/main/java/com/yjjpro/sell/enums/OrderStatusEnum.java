package com.yjjpro.sell.enums;

import lombok.Getter;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 18:50
 * @Description: 订单状态枚举类
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完成订单"),
    CANCEL(2,"已取消");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

}
