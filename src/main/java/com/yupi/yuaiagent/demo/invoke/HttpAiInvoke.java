package com.yupi.yuaiagent.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

public class HttpAiInvoke {
    public static void main(String[] args) {
//        // 从环境变量获取API密钥
//        String apiKey = TestApiKey.API_KEY;
//        if (apiKey == null || apiKey.isEmpty()) {
//            System.err.println("请设置环境变量 DASHSCOPE_API_KEY");
//            return;
//        }
//
//        // 构建请求URL
//        String url = "https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions";
//
//        // 创建消息列表
//        JSONArray messages = new JSONArray();
//
//        // 添加system消息
//        JSONObject systemMessage = new JSONObject();
//        systemMessage.put("role", "system");
//        systemMessage.put("content", "You are a helpful assistant.");
//        messages.put(systemMessage);
//
//        // 添加user消息
//        JSONObject userMessage = new JSONObject();
//        userMessage.put("role", "user");
//        userMessage.put("content", "好难过，安慰我一下");
//        messages.put(userMessage);
//
//        // 构建请求体JSON
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("model", "qwen-plus");
//        requestBody.put("messages", messages);
//
//        // 发送HTTP请求
//        HttpResponse response = HttpRequest.post(url)
//                .header("Authorization", "Bearer " + apiKey)
//                .header("Content-Type", "application/json")
//                .body(requestBody.toString())
//                .execute();
//
//        // 处理响应
//        if (response.isOk()) {
//            System.out.println("请求成功:");
//            System.out.println(response.body());
//        } else {
//            System.err.println("请求失败，状态码: " + response.getStatus());
//            System.err.println(response.body());
//        }
    }
}
