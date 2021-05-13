package com.dongazul.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dongazul.myapp.domain.ProfileDTO;
import com.dongazul.myapp.service.ProfileService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Controller
@RequestMapping("/matching")
public class MatchingController {

	@Autowired
	ProfileService profileService;
	
	// 메인화면 보여주기
	@GetMapping("/swipe")
	public void swipeGet(Model model) throws Exception {
		
		log.debug("swipeGet(model) invoked.");
		
		List<ProfileDTO> list = this.profileService.selectProfileWithThem();
		
		model.addAttribute("LIST", list);
		
		log.debug("swipeGet() invoked.");
	} // swipeGet
	
	@GetMapping("/profile")
	public void profileGet() {
		
		log.debug("profileGet() invoked.");
	} // profileGet
	
	@PostMapping("/like")
	public void likePost() {
		
		log.debug("likePost() invoked.");
	} // likePost

} // end class
