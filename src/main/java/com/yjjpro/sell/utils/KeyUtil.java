package com.yjjpro.sell.utils;

import java.util.Random;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 21:51
 * @Description:
 */

public class KeyUtil {
    /**生成唯一的主键
     * 格式: 时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer a = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(a);
    }
}
