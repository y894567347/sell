package com.yjjpro.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/1/8 17:05
 * @Description: 商品类目实体类
 */
@Entity
@DynamicUpdate  //动态修改更新时间
@Data   //自动生成GetSet方法以及toString()等方法
public class ProductCategory {

    /**类目ID.*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer categoryId;
    /**类目名称.*/
    private String categoryName;
     /**类目编号.*/
    private Integer categoryType;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        
    }

    public ProductCategory() {
    }
}
