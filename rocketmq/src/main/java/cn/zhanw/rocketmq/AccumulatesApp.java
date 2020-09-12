package cn.zhanw.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;


/**
 * Created by xujingfeng on 2017/4/28.
 */
@SpringBootApplication(exclude = SessionAutoConfiguration.class)
public class AccumulatesApp {
    public static void main(String []args){
        SpringApplication.run(AccumulatesApp.class,args);
    }
}
