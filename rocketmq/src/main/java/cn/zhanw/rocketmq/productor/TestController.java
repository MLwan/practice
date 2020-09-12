package cn.zhanw.rocketmq.productor;

import cn.zhanw.rocketmq.config.RocketContants;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujingfeng on 2017/5/8.
 */
@RestController
public class TestController {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/testRmq")
    public String send(@RequestBody String msg) throws Exception {
        //MQ发送方式一:发送Message对象
//        Message message = new Message();
//        message.setTopic(RocketContants.MAIL_TOPIC);
//        message.putUserProperty("mailId", "DBID");
//        message.setBody(msg.getBytes());

        Message message = new Message(RocketContants.MAIL_TOPIC, "mail_send", "MailId", msg.getBytes());
        rocketMQTemplate.getProducer().send(message);


        //MQ发送方式二:
//        rocketMQTemplate.convertAndSend(RocketContants.MAIL_TOPIC,msg);


        return "success";
    }

}
