package com.yupi.yuaiagent.app;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;
import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_RETRIEVE_SIZE_KEY;

@Component
@Slf4j
public class LoveApp {
    //使用构造函数创建chatClient
    private static final String SYSTEM_PROMPT = "扮演深耕恋爱心理领域的专家。开场向用户表明身份，告知用户可倾诉恋爱难题。" +
            "围绕单身、恋爱、已婚三种状态提问：单身状态询问社交圈拓展及追求心仪对象的困扰；" +
            "恋爱状态询问沟通、习惯差异引发的矛盾；已婚状态询问家庭责任与亲属关系处理的问题。" +
            "引导用户详述事情经过、对方反应及自身想法，以便给出专属解决方案。";
    private final ChatClient chatClient;

    //恋爱知识库的功能
    @Resource
    private VectorStore loveAppVectorStore;

    @Resource
    private Advisor loveAppRagCloudAdvisor;
    /**
     * 初始化
     * @param dashScopeChatModel
     */
    public LoveApp(ChatModel dashScopeChatModel) {
        ChatMemory chatMemory = new InMemoryChatMemory();
        //基于内存的对话记忆
         this.chatClient = ChatClient
                 .builder(dashScopeChatModel)
                 .defaultSystem(SYSTEM_PROMPT)
                 .defaultAdvisors(
                        new MessageChatMemoryAdvisor(chatMemory)
                        ,new SimpleLoggerAdvisor()
                 )
                 .build();
    }
    /**
     * 支持多轮会话记忆
     * @param message
     * @param chatId
     * @return
     */
    public String doChat(String message,String chatId) {
        ChatResponse chatResponse = chatClient.prompt()
                .user(message)
                .advisors(spec -> spec.param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId)
                        .param(CHAT_MEMORY_RETRIEVE_SIZE_KEY, 10))
                .call()
                .chatResponse();
        String text = chatResponse.getResult().getOutput().getText();
        log.info("text:{}",text);
        return text;
    }

    /**
     * 与Rag知识库 进行 对话
     * @param message
     * @param chatId
     * @return
     */
    public String doChatWithRag(String message,String chatId) {
        ChatResponse chatResponse = chatClient.prompt()
                .user(message)
                .advisors(spec -> spec.param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId)
                        .param(CHAT_MEMORY_RETRIEVE_SIZE_KEY, 10))
                //开启Rag知识库问答
                //.advisors(new QuestionAnswerAdvisor(loveAppVectorStore))
                //应用Rag检索增强服务（基于云知识库服务）
                .advisors(loveAppRagCloudAdvisor)
                .call()
                .chatResponse();
        String text = chatResponse.getResult().getOutput().getText();
        log.info("text:{}",text);
        return text;
    }
}
