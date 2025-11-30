package com.example.SpringAICodeOllama.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAiCodeOllamaController {

    private final ChatClient chatClient;

    public SpringAiCodeOllamaController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value = "prompt") String prompt){
        var reply = this.chatClient.prompt(prompt).call().content();
        return ResponseEntity.ok(reply);

    }
}
