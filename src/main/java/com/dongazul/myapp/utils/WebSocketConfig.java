package com.dongazul.myapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
@Configuration
@EnableWebSocket

@NoArgsConstructor
@Log4j
public class WebSocketConfig implements WebSocketConfigurer {

	@Autowired
	private EchoHandler echoHandler;
	
	@Override
	public void registerWebSocketHandlers(
			WebSocketHandlerRegistry registry) {
		
		log.debug("registerWebSocketHandlers(registry) invoked.");
		
		registry.addHandler(echoHandler, "/echo").setAllowedOrigins("*").withSockJS()
		.setInterceptors(new HttpSessionHandshakeInterceptor()).
		setClientLibraryUrl("http://localhost:8080/resources/sockjs.min.js");
		
	} // registerWebSocketHandlers
	
} // end class
