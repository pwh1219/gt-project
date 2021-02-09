package com.gt.gtcommon.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 增删改商品时，把商品信息发送到mq服务器，前台系统会根据商品信息删除缓存、全文搜索子系统会更新
     */
    public void sentMessage(String jsonItem) throws Exception {
        // 发送消息
        rabbitTemplate.convertAndSend(jsonItem);
    }

}
