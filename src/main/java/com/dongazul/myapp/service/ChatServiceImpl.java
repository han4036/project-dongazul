package com.dongazul.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongazul.myapp.domain.ChatDTO;
import com.dongazul.myapp.mapper.ChatMapper;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@NoArgsConstructor
@Log4j
@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	ChatMapper mapper;
	
	@Override
	public void addChatroom(ChatDTO dto) throws Exception {
		log.debug("addChatroom(dto) invoked.");
		
		this.mapper.addChatroom(dto);
	} // addChatroom

	@Override
	public List<ChatDTO> getChatroom() throws Exception {
		
		log.debug("chatroom() invoked.");
		
		return this.mapper.getChatroom();
	} // getChatroom

} // end class
