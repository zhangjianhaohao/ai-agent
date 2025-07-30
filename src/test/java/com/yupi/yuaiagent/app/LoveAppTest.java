package com.yupi.yuaiagent.app;

import cn.hutool.core.lang.UUID;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j

@SpringBootTest
class LoveAppTest {

    @Resource
    private LoveApp loveApp;
    @Test
    void testChat() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是程序员鱼皮";
        String answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        // 第二轮
//        message = "我想让另一半（编程导航）更爱我";
//        answer = loveApp.doChat(message, chatId);
//        Assertions.assertNotNull(answer);
        // 第三轮
//        message = "我的另一半叫什么来着？刚跟你说过，帮我回忆一下,我只需要你回答我的另一半叫什么";
//        answer = loveApp.doChat(message, chatId);
//        Assertions.assertNotNull(answer);

    }

    @Test
    void doChat() {
    }

    @Test
    void doChatWithRag() {
        String chatId = UUID.randomUUID().toString();
        String message = "我已经结婚了，但是婚后关系不太亲密，怎么办？";
        String answer =  loveApp.doChatWithRag(message, chatId);
        Assertions.assertNotNull(answer);
    }
}