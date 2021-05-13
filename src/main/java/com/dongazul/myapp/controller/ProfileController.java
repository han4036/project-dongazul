package com.dongazul.myapp.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.ProfileDTO;
import com.dongazul.myapp.service.ProfileService;
import com.dongazul.myapp.utils.UploadFileUtils;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	public static final String profileKey = "profile";
	
	@Autowired
	ProfileService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@GetMapping("/create")
	public void createGet() {
		
		log.debug("createGet() invoked.");
	} // createGet
	
	@PostMapping("/create")
	public String createPost(
			ProfileDTO dto, 
			MultipartFile file, 
			RedirectAttributes rttrs
			) throws Exception {
		
		log.debug("createPost() invoked");
		
		String imgUploadPath = 
				uploadPath + File.separator + "imgUpload";
		
		String ymdPath = 
				UploadFileUtils.calcPath(imgUploadPath);
		
		String fileName = null;
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			
			fileName = 
					UploadFileUtils.FileUpload(
							imgUploadPath, 
							file.getOriginalFilename(), 
							file.getBytes(), 
							ymdPath
							);
			
		} else {
			
			fileName = 
					uploadPath + File.separator + "images" 
							   + File.separator + "none.png";
		} // if-else
		
		
		dto.setImageRoot(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		
		log.info(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		
		dto.setImgThumbImg(
				File.separator + "imgUpload" + ymdPath + File.separator 
							   + "s" + File.separator + "s_" + fileName
				);
		
		this.service.craeteProfile(dto);
		
		rttrs.addFlashAttribute("msg", "프로필 생성이 완료되었습니다.");
		return "redirect:/matching/swipe";
	} // createPost
	
	@GetMapping("/info")
	public String infoGet(
			String email,
			HttpSession session, 
			RedirectAttributes rttrs
			) throws Exception {
		
		log.debug("infoGet() invoked.");
		
		ProfileDTO profile = this.service.getProfile(email);
		
		if(profile == null) {

			rttrs.addAttribute("email", email);
			
			return "redirect:/profile/create";
		} // if
		
		session.setAttribute(profileKey, profile);
		
		return "profile/info";
	} // infoGet
	
	@GetMapping("/infoThem")
	public void infoThem(
			String email,
			RedirectAttributes rttrs,
			Model model
			) throws Exception {
		
		log.debug("infoGet() invoked.");
		
		ProfileDTO profile = this.service.getProfile(email);
		model.addAttribute(profileKey, profile);
	} // infoGet
	
	@GetMapping("/update")
	public void updateGet() {
		log.debug("updateGet() invoked.");
		
	} // updatePost
	
	@PostMapping("/update")
	public String updatePost(
			ProfileDTO dto, 
			RedirectAttributes rttrs,
			MultipartFile file
			) throws Exception {
		
		log.debug("updatePost() invoked.");
		String imgUploadPath = 
				uploadPath + File.separator + "imgUpload";
		
		String ymdPath = 
				UploadFileUtils.calcPath(imgUploadPath);
		
		String fileName = null;
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			
			fileName = 
					UploadFileUtils.FileUpload(
							imgUploadPath, 
							file.getOriginalFilename(), 
							file.getBytes(), 
							ymdPath
							);
			
		} else {
			
			fileName = 
					uploadPath + File.separator + "images" 
							   + File.separator + "none.png";
		} // if-else
		
		
		dto.setImageRoot(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		
		log.info(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		
		dto.setImgThumbImg(
				File.separator + "imgUpload" + ymdPath + File.separator 
							   + "s" + File.separator + "s_" + fileName
				);
		
		
		this.service.modifyProfile(dto);
		
		rttrs.addFlashAttribute("msg", "수정이 완료되었습니다.");
	
		
		return "redirect:/matching/swipe";
	} // updatePost
	

	
} // end class
