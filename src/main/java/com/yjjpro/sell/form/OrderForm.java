package com.yjjpro.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/2 13:34
 * @Description: 订单表单
 */
@Data
public class OrderForm {
    /**卖家姓名.*/
    @NotEmpty(message = "姓名必填")
    private String name;

    /**卖家手机号.*/
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**买家地址.*/
    @NotEmpty(message = "地址必填")
    private String address;

    /**买家微信.*/
    @NotEmpty(message = "微信必填")
    private String openid;

    //购物车
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
