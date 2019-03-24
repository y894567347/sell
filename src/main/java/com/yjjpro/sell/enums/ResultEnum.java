package com.yjjpro.sell.enums;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Getter;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 20:56
 * @Description:返回给前端的错误提示
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不正确"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_ERROR(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17,"支付状态不正确"),
    CART_EMPTY(18,"购物车为空"),
    ORDER_OWNER_ERROR(19,"该订单不属于当前用户"),
    WeChat_MP_ERROR(20,"微信公众号错误")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

}
