package com.hotyum.stars.utils;

import java.util.UUID;

/**
 * @author ybm
 * @version V1.0
 * @Title UUID工具类
 * @Description
 * @date 2017/8/29
 */
public class UuidUtil {
    public static String getUuid(){
        UUID uuid = UUID.randomUUID();
        String uuidStr =  uuid.toString();
        uuidStr = uuidStr.replace("-", "");
        return uuidStr;
    }

}
