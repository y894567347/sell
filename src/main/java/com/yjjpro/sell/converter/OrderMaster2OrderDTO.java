package com.yjjpro.sell.converter;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.yjjpro.sell.dataobject.OrderMaster;
import com.yjjpro.sell.dto.OrderDTO;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/28 20:54
 * @Description:
 */
public class OrderMaster2OrderDTO {

    public static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;

    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){

        return orderMasterList.stream().map(e ->
                convert(e)).collect(Collectors.toList());

    }
}
