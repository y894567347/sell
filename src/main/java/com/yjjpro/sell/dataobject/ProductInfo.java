package com.yjjpro.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/1/22 18:28
 * @Description:商品实体类
 */
@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    //商品库存
    private Integer productStock;
    private String  productDescription;
    //商品小图
    private String productIcon;
    private Integer productStatus;//商品状态 0正常 1下架
    //类目编号
    private Integer categoryType;

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }

    public ProductInfo() {
    }
}



