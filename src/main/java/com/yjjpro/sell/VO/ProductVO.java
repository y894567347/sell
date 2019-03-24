package com.yjjpro.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yjjpro.sell.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/26 21:04
 * @Description:商品（含类目） VO (VIEW OBJECT) 返回视图的商品对象
 */
@Data
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
