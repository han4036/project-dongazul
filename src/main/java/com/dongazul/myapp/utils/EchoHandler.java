package com.dongazul.myapp.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.ProfileDTO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@NoArgsConstructor
@Log4j
@Component
public class EchoHandler extends TextWebSocketHandler{
	
	
    //세션 리스트
    private List<WebSocketSession> sessions = new ArrayList<>();
    
    Map<String, WebSocketSession> userSessionsMap = new HashMap<>();
    
    //클라이언트가 연결 되었을 때 실행
    @Override
    public void afterConnectionEstablished(
    			WebSocketSession session
    			) throws Exception {
    	
    	log.debug("afterConnectionEstablished(session) invoked.");
    	
        sessions.add(session);
        
        String senderEmail = this.getEmail(session);
        
        log.info("\t+ email: " + senderEmail);
        
        
		userSessionsMap.put(senderEmail , session);
		
    } // afterConnectionEstablished

    //클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
    @Override
    protected void handleTextMessage(
    			WebSocketSession session,
    			TextMessage message
    			) throws Exception {
    	
    	log.debug("handleTextMessage(session, message) invoked.");
    	
    	
    	Map<String, Object> httpSession = session.getAttributes();
    	ProfileDTO profile = (ProfileDTO) httpSession.get("profile");
    	
        //모든 유저에게 메시지 출력
        for(WebSocketSession sess : sessions){
        	
            sess.sendMessage(new TextMessage(session.getId()+ ":"+ message.getPayload()));
            
            log.info(profile.getNickname()+" : "+message.getPayload());
        } // enhanced for
        
    } // handleTextMessage

    //클라이언트 연결을 끊었을 때 실행
    @Override
    public void afterConnectionClosed(
    		WebSocketSession session,
    		CloseStatus status
    		) throws Exception {
    	
    	log.debug("afterConnectionClosed(session, status) invoked.");
    	
    	
    	
    	userSessionsMap.remove(session.getId());
		sessions.remove(session);
        
    } // afterConnectionClosed
    
    private String getEmail(WebSocketSession session) {
		
    	Map<String, Object> httpSession = session.getAttributes();
		MemberVO loginUser = (MemberVO) httpSession.get("member");
		
		if(loginUser == null) {
			
			return session.getId();
			
		} else {
			
			log.info("HttpSession succeed.");
			
			return loginUser.getEmail();
		}
	}

} // end class
