package com.zcct.security.demo.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.zcct.security.demo.exception.BadRequestException;

import java.util.Collection;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/31 20:19
 */
public class ValidateUtils {

    public static void isNull(Object obj, String name){
        if(ObjectUtil.isNull(obj)){
            String msg = " 参数 "+ name + " 不能为空 ";
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isNull(Collection collection, String name){
        if(CollectionUtil.isEmpty(collection)){
            String msg = " 参数 "+ name + " 不能为空 ";
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isTrue(Boolean flag, String tip){
        if(flag){
            throw new BadRequestException(tip);
        }
    }
}
