package com.example.chat.config;


import com.example.chat.config.handler.ChatWebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatWebSocketHandler chatWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("[+] 최초 WebSocket 연결을 위한 등록 Handler");
        registry
                // 클라이언트에서 웹 소켓 연결을 위해 "ws-stomp"라는 엔드포인트에 연결을 시도하면 ChatWebSocketHandler 클래스에서 처리함
                .addHandler(chatWebSocketHandler, "ws-stomp")
                .setAllowedOrigins("*");
    }

}
