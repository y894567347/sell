package com.yjjpro.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/7 21:16
 * @Description: 弃用
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){

    log.info("进入auth方法............");
    log.info(code);

    String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxe3f64d69f3f9e020&secret=60d074a5f4fc93b724cdb0e597c75497&code="+code+"&grant_type=authorization_code";
    RestTemplate restTemplate = new RestTemplate();
    String response = restTemplate.getForObject(url,String.class);
    log.info("response ="+response);
    }
}
