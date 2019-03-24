package com.yjjpro.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/7 22:15
 * @Description:  将yml中的wechat字段 赋值
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    private String mchId;

    private String mchKey;

    private String keyPath;

    /**微信支付异步通知地址.*/
    private String notifyUrl;
}
