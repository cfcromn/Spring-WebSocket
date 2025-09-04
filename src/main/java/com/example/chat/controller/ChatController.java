package com.example.chat.controller;

import com.example.chat.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template;

    @MessageMapping("/messages") // 클라: /pub/messages 로 보냄
    public void send(@Payload ChatMessageDto chatMessageDto) {
        template.convertAndSend("/sub/messages", chatMessageDto.getContent());
    }
}
