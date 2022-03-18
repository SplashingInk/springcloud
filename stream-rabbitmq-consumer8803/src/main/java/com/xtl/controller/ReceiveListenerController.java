package com.xtl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @ClassName ReceiveListenerController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/6 14:43
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("收到的消息："+message.getPayload()+"\t server port:"+serverPort);
    }
}
