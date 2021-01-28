package cn.com.codingce.springcloud.dao.impl;
/*
 *
 * @Classname ConsumerListener
 * @Description TODO
 * @Date 2021/1/27 14:28
 * @author TonyWang
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

    @KafkaListener(topics = "test1")
    public void listen1(@Payload String message){
        logger.info("received message1={}",message);
    }


}

