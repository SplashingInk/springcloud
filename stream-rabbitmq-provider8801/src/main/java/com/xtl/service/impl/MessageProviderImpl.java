package com.xtl.service.impl;

import cn.hutool.core.util.IdUtil;
import com.xtl.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName MessageProviderImpl
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/6 14:05
 */
@Slf4j
@Component
@EnableBinding(Source.class)
public class MessageProviderImpl  implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = IdUtil.simpleUUID();
        log.info("serial:"+serial);
        output.send(MessageBuilder.withPayload(serial).build());
        return null;
    }
}
