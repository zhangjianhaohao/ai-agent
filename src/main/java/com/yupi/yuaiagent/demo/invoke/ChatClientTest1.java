package com.yupi.yuaiagent.demo.invoke;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建ChatClient
 */
@Service
@Slf4j
public class ChatClientTest1/* implements CommandLineRunner*/ {
    private final ChatClient chatClient;
    public ChatClientTest1(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("你是个恋爱博主")
                .build();
    }

//    @Override
//    public void run(String... args) throws Exception {
//        ChatResponse response = chatClient.prompt()
//                .advisors(
//                        new MessageChatMemoryAdvisor(new ChatMemory()
//                        {
//                            @Override
//                            public void add(String conversationId, List<Message> messages) {
//
//                            }
//
//                            @Override
//                            public List<Message> get(String conversationId, int lastN) {
//                                return List.of();
//                            }
//
//                            @Override
//                            public void clear(String conversationId) {
//
//                            }
//                        })
//                )
//                .user("男朋友绿了我 我应该怎么办")
//                .call()
//                .chatResponse();
//        System.out.println(response.getMetadata().getUsage());
//        System.out.println(response.getResult().getOutput().getText());
//    }
}

