package com.john.ai.AIFunctions.controller;

import java.util.List;

import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaChatController {
    private final OllamaChatModel chatModel;

    @Autowired
    public OllamaChatController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }
    @GetMapping("/chat")
    public String chat(@RequestParam(value = "message", defaultValue = "What is the weather in chennai today?") String message) {
        SystemMessage systemMessage = new SystemMessage("You are a helpful chat client. You respond to the requests like a pirate and jokingly. Do not make up responses if you don't know the answer.");
        UserMessage userMessage = new UserMessage(message);
        OllamaOptions functionOptions = OllamaOptions.builder().withFunction("currentWeather").build(); 
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage), functionOptions);
        return chatModel.call(prompt).getResult().getOutput().getContent();
    }

}
