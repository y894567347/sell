package com.yjjpro.sell.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.yjjpro.sell.dataobject.OrderDetail;
import com.yjjpro.sell.dto.OrderDTO;
import com.yjjpro.sell.enums.ResultEnum;
import com.yjjpro.sell.exception.SellException;
import com.yjjpro.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/2 14:00
 * @Description:
 */
@Slf4j
public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        //不能使用BeanUtils复制参数值  因为两个类的字段名不同
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerAddress(orderForm.getAddress());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        try {
           orderDetailList =  gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【对象转换】 错误 json={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
         }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
