package com.yjjpro.sell.controller;

import com.lly835.bestpay.model.PayResponse;
import com.yjjpro.sell.dto.OrderDTO;
import com.yjjpro.sell.enums.ResultEnum;
import com.yjjpro.sell.exception.SellException;
import com.yjjpro.sell.service.OrderService;
import com.yjjpro.sell.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.PreUpdate;
import java.util.Map;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/9 11:52
 * @Description:微信支付Controller
 */

@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object> map){

        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        PayResponse payResponse =  payService.create(orderDTO);
        map.put("payResponse",payResponse);
        //发起支付
        map.put("returnUrl",returnUrl);

        return new ModelAndView("pay/create",map);
    }


}
