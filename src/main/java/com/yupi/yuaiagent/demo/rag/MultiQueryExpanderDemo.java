package com.yupi.yuaiagent.demo.rag;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.rag.Query;
import org.springframework.ai.rag.preretrieval.query.expansion.MultiQueryExpander;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MultiQueryExpanderDemo {
    @Resource
    private final ChatClient.Builder chatClientBuilder;
    public MultiQueryExpanderDemo(ChatModel dashscopeChatModel) {
        this.chatClientBuilder = ChatClient.builder(dashscopeChatModel);
    }
    public List<Query> expand(Query query) {
        MultiQueryExpander expander = MultiQueryExpander.builder().
                chatClientBuilder(chatClientBuilder).
                numberOfQueries(3).
                build();
        List<Query> queries = expander.expand(query);
        return queries;
    }
}
