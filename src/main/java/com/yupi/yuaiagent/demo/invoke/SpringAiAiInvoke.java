package com.yupi.yuaiagent.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;

/**
 * Spring AI框架调用AI 大模型
 */
public class SpringAiAiInvoke  implements CommandLineRunner {

    @Resource
    private ChatModel dashScopeChatModel; //ChatClient 适合于更复杂的
    @Override
    public void run(String... args) throws Exception {
        AssistantMessage assistantMessage = dashScopeChatModel.call(new Prompt("你好呀"))
                .getResult()
                .getOutput();
        System.out.println(assistantMessage.getText());
    }
}