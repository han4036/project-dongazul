package com.dongazul.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dongazul.myapp.domain.ChatDTO;
import com.dongazul.myapp.domain.ProfileDTO;
import com.dongazul.myapp.service.ChatService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@RequestMapping("/chat")

@Controller
public class ChatController {

	@Autowired
	ChatService service;
	
	
	@PostMapping("/open")
	public void openPost() {
		log.debug("openPost() invoked.");

	} // ChatController
	
	@GetMapping("/do")
	public void doGet(Model model, HttpSession session) {
		
		log.debug("doGet(model, session) invoked.");
	
		ProfileDTO profile = (ProfileDTO)session.getAttribute("profile");
		
		model.addAttribute("profile", profile);
	
		
	} // roomsGet
	
	@GetMapping("/rooms")
	public void roomGet() {
		
		log.debug("roomGet() invoked.");

	} // windowGet
	
	@PostMapping("/rooms")
	public String roomPost(ChatDTO dto) throws Exception {
		log.debug("roomPost() invoked.");
		
		this.service.addChatroom(dto);
		
		return "redirect:/chat/windows";
		
	} // doPost
	
	@GetMapping("/windows")
	public void windows(Model model) throws Exception {
		log.debug("windows() invoked.");
	
		List<ChatDTO> list = this.service.getChatroom();
		
		model.addAttribute("LISTCHAT", list);
	} // exitPost
	
	
	
} // end class
