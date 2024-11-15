package com.team.green.chat.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;


@Configuration  // �ٸ� context ����ó�� ���� �⵿�� �ڵ����� �ε��
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	
    	// /subscribe�� �����ϴ� "destination" ����� ���� �޼����� ���Ŀ�� ������Ѵ�.
        config.enableSimpleBroker("/subscribe");
        
        // �̷��� �����ְ� /app/hello/' + roomNo ���·� ��û�ϸ�
        // ChatLogController�� @MessageMapping("/hello/{roomNo}")�� ����
        config.setApplicationDestinationPrefixes("/app");  
    }
    
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	// WebSocket �Ǵ� SockJS Client�� ������ �ڵ����ũ Ŀ�ؼ��� ������ ���
        registry.addEndpoint("/endpoint").withSockJS();
    }

	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
	}

	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration registration) {
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
	}

	@Override
	public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
		return true;
	}
}
