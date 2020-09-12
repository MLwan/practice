package cn.zhanw.rocketmq.consumer;

import cn.zhanw.rocketmq.config.RocketContants;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = RocketContants.CONSUMER_GROUP, topic = RocketContants.MAIL_TOPIC)
public class MqListener implements RocketMQListener<MessageExt>{

    @SneakyThrows
    @Override
    public void onMessage(MessageExt messageExt) {
//        System.out.println("msgID"+message.getUserProperty("mailId"));
//        System.out.println("msgBodt"+message.getBody());
        //1. 解析消息内容
        String body = new String(messageExt.getBody(), "UTF-8");
        //MQEntity mqEntity = JSON.parseObject(body, MQEntity.class);

        log.info("rocketMQ receive{}", messageExt);
        log.info("msgBody:{}",body);
        log.info("msgKeys:{}",messageExt.getKeys());
    }
}
