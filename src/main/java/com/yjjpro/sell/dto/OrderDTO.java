package com.yjjpro.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yjjpro.sell.dataobject.OrderDetail;
import com.yjjpro.sell.enums.OrderStatusEnum;
import com.yjjpro.sell.enums.PayStatusEnum;
import com.yjjpro.sell.utils.Date2LongSerializer;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 20:26
 * @Description: 订单数据传输层
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
/**不返回类中字段值为空的字段.*/
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /**订单id.*/

    private String orderId;

    /**卖家名字.*/
    private String buyerName;

    /**买家电话.*/
    private String buyerPhone;

    /**买家地址.*/
    private String buyerAddress;

    /**买家微信.*/
    private String buyerOpenid;

    /**订单总价.*/
    private BigDecimal orderAmount;

    /**订单状态，默认0下单.*/
    private Integer orderStatus;

    /**支付状态，默认0未支付.*/
    private Integer payStatus;

    /**订单详情列表.*/
    private List<OrderDetail> orderDetailList;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
}
