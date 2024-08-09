package com.zcct.rocketmq.service;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2024/8/9 10:17
 * @description:
 */
@Component
public class RocketMqUtil {

    private final RocketMQTemplate rocketMQTemplate;

    @Autowired
    public RocketMqUtil(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    /**
     * 同步发送消息
     * @param topic 主题
     * @param tag 标签
     * @param message 消息内容
     */
    public void sendMessageSync(String topic, String tag, String message) {
        rocketMQTemplate.syncSend(topic + ":" + tag, message);
    }

    /**
     * 异步发送消息
     * @param topic 主题
     * @param tag 标签
     * @param message 消息内容
     * @param callback 回调函数
     */
    public void sendMessageAsync(String topic, String tag, String message, SendCallback callback) {
        rocketMQTemplate.asyncSend(topic + ":" + tag, message, callback);
    }

    /**
     * 单向发送消息
     * @param topic 主题
     * @param tag 标签
     * @param message 消息内容
     */
    public void sendOneWayMessage(String topic, String tag, String message) {
        rocketMQTemplate.sendOneWay(topic + ":" + tag, message);
    }

}
