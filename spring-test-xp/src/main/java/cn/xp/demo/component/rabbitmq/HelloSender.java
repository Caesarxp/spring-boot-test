package cn.xp.demo.component.rabbitmq;//package cn.xp.demo.component.rabbitmq;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * @Description: TODO
// * @Author: xp
// * @CreateDate: 2021/1/23 13:57
// * @UpdateUser: 熊鹏
// * @Version: 1.0
// */
//@Component
//public class HelloSender {
//    @Autowired
//    private AmqpTemplate rabbitTemplate;
//
//    public void send() {
//        String context = "hello " + new Date();
//        System.out.println("Sender : " + context);
//        this.rabbitTemplate.convertAndSend("hello", context);
//    }
//}
