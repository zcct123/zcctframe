package com.zcct.common.web.domain;

import java.util.HashMap;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 13:31
 * @description: 返回消息
 */
public class ResultInfo extends HashMap<String, Object> {

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /** 时间戳 */
    public static final String TIME_TAG = "timestamp";

    public ResultInfo()
    {
        super.put(TIME_TAG , System.currentTimeMillis());
        super.put(CODE_TAG, 200);
        super.put(DATA_TAG, null);
        super.put(MSG_TAG, null);
    }

    public ResultInfo(Object data)
    {
        super.put(TIME_TAG , System.currentTimeMillis());
        super.put(CODE_TAG, 200);
        super.put(DATA_TAG, data);
        super.put(MSG_TAG, null);
    }

    public ResultInfo(int code, String msg)
    {
        super.put(TIME_TAG , System.currentTimeMillis());
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, null);
    }

    /**
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public ResultInfo(int code, String msg, Object data)
    {
        super.put(TIME_TAG , System.currentTimeMillis());
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
    }

}
