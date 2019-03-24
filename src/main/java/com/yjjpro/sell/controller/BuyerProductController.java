package com.yjjpro.sell.controller;

import com.yjjpro.sell.VO.ProductInfoVO;
import com.yjjpro.sell.VO.ProductVO;
import com.yjjpro.sell.VO.ResultVO;
import com.yjjpro.sell.dataobject.ProductCategory;
import com.yjjpro.sell.dataobject.ProductInfo;
import com.yjjpro.sell.service.CategoryService;
import com.yjjpro.sell.service.ProductService;
import com.yjjpro.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/26 20:40
 * @Description:买家控制类
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

@GetMapping("/list")
    public ResultVO list(){
    //查询所有商家商品
    List<ProductInfo> productInfoList=productService.findUpAll();
    //查询类目
    //java8 lambda表达式  将商品列表中的每个类目Type提取出来转化为一个Integer列表
    List<Integer> categoryTypeList=productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
    List<ProductCategory> productCategoryList=categoryService.findAllByType(categoryTypeList);
    //数据封装

    List<ProductVO> productVOList=new ArrayList<>();
    for(ProductCategory productCategory:productCategoryList)
    {
        ProductVO productVO=new ProductVO();
        productVO.setCategoryType(productCategory.getCategoryType());
        productVO.setCategoryName(productCategory.getCategoryName());
        List<ProductInfoVO> productInfoVOList=new ArrayList<>();
        for(ProductInfo productInfo:productInfoList)
        {
            if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                //相比于上面的方法 spring 提供了方法来将一个类中的属性复制到另一个类中
                ProductInfoVO productInfoVO=new ProductInfoVO();
                BeanUtils.copyProperties(productInfo,productInfoVO);
                productInfoVOList.add(productInfoVO);
            }
        }
        productVO.setProductInfoVOList(productInfoVOList);
        productVOList.add(productVO);
    }
    return ResultVOUtil.success(productVOList);

}

}
