package com.dongazul.myapp.mapper;

import java.util.List;

import com.dongazul.myapp.domain.ChatDTO;

public interface ChatMapper {
	
	// 채팅방 생성
	public abstract void addChatroom(ChatDTO dto) throws Exception;
	// 채팅방 목록 불러오기
	public abstract List<ChatDTO> getChatroom() throws Exception;
	
	
} // end class
