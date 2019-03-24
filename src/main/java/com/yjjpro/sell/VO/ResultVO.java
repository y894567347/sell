package com.yjjpro.sell.VO;

import lombok.Data;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/26 20:45
 * @Description:  http请求返回的最外层对象
 */
@Data
public class ResultVO<T> {
    /**错误码.*/
    private Integer code;
    /**提示信息.*/
    private String msg;
    /**具体内容.*/
    private T data;

}
