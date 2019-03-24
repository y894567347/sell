package com.yjjpro.sell.exception;

import com.yjjpro.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 20:55
 * @Description:
 */
@Getter
public class SellException extends  RuntimeException {
    private Integer code;


    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());

        this.code=resultEnum.getCode();
    }

    public SellException(Integer code,String msg){
        super(msg);
        this.code = code;
    }
}
