package com.yjjpro.sell.dataobject;

import com.yjjpro.sell.enums.OrderStatusEnum;
import com.yjjpro.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 16:57
 * @Description:订单实体类
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    /**订单id.*/
    @Id
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
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    /**支付状态，默认0未支付.*/
    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;


}
