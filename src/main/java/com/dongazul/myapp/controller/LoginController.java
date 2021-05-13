package com.dongazul.myapp.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.dongazul.myapp.domain.EmailDTO;
import com.dongazul.myapp.domain.LoginDTO;
import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.ProfileDTO;
import com.dongazul.myapp.interceptor.AuthInterceptor;
import com.dongazul.myapp.service.MemberService;
import com.dongazul.myapp.service.ProfileService;
import com.dongazul.myapp.utils.EmailSender;
import com.dongazul.myapp.utils.TempKey;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Controller
@RequestMapping("/login")
public class LoginController {
	
	public static final String loginKey = "member";	
	
	public static final String rememberMeKey = 
					AuthInterceptor.rememberMeKey;
	
	@Autowired
	private MemberService memberservice;
	@Autowired
	private ProfileService profileService;
	
	 @Autowired
	private EmailSender emailSender;

	
	
	// 로그인 처리
	@PostMapping("/signInPost")
	public String signInPost(
				LoginDTO dto,
				HttpSession session,
				Model model) throws Exception {
		
		log.debug("signInPost(dto, session, model) invoked.");
		
		MemberVO signIn = this.memberservice.signIn(dto);
		
		if(signIn != null) {
			
			model.addAttribute(loginKey, signIn);
			
			if(dto.isRememberme()) {
				
				   String email = dto.getEmail();
				   String rememberme = session.getId();
				   
				   int timeAmount = 1000 * 60 * 24 * 7;
				   Date rememberage =
						   new Date(System.currentTimeMillis() + timeAmount);
				   
				   this.memberservice.
				   updateMemberWithRememberMe(email, rememberme, rememberage);
				   
				   log.info("\t+ 자동로그인 정보 업데이트 완료.");
			} // if
		} 

		return null;	
	} // signInPost
	
	// 로그아웃 처리
	@GetMapping("/signOut")
	public String signOutGet(
			HttpServletRequest req,
			HttpServletResponse res,
			HttpSession session) throws Exception {
		
		log.debug("signOutGet(session) invoked.");
		
		MemberVO signIn = (MemberVO) session.getAttribute(loginKey);
		
		session.invalidate();
		
		Cookie rememberMeCookie = 
				WebUtils.getCookie(req, rememberMeKey);
			
		if(rememberMeCookie != null) {
			
			rememberMeCookie.setPath("/");
			rememberMeCookie.setMaxAge(0);	/*** 쿠키파괴를 위한 가장 중요한 설정 ***/
				
			res.addCookie(rememberMeCookie);	// 브라우저로 이 쿠키가 전송 => 파괴
		} // if
		
		if(signIn != null) {
			this.memberservice.
			updateMemberWithRememberMe(signIn.getEmail(), null, null);			
		} // if
		
		return "redirect:/";
	} // signOutPost
	
	// 아이디 찾기 화면
   @GetMapping("/findId")
   public void findIdGet() {
	   
      log.debug("findIdGet() invoked.");      
   } // findIdGet
   
   // 아아디 찾기 처리
   @PostMapping("/findIdResult")
   public String findIdPost(
		   MemberVO vo, 
		   Integer phonenumber, 
		   HttpSession session,
		   RedirectAttributes rttrs
		   ) throws Exception {
	   
      log.debug("findIdPost(phoneNumber) invoked.");
      
      String result = memberservice.findId(phonenumber);
      
      if(result != null) {
    	  session.setAttribute("FIND", result);
    	  return "/login/findIdResult";
      } else {
    	  rttrs.addFlashAttribute("msg", "이메일을 잘못입력하셨습니다");
    	  return "redirect:/login/findId";
      } // if-else
   } // findIdPost
   
   // 비밀번호 찾기 화면
   @GetMapping("/findPw")
   public void findPwGet() {
	   
      log.debug("findPwGet() invoked.");
   } // findPwGet
   
   // 비밀번호 찾기 처리
   @PostMapping("/findPwResult")
   public String findPwPost (
		   			EmailDTO emailDTO,
		   			String email, 
		   			Integer phonenumber,
		   			RedirectAttributes rttrs
		   			) throws Exception {
      
	   log.info("findPwPost(email, phonenumber, rttrs) invoked");	
	   
	   String pw = this.memberservice.findPw(email, phonenumber);
	   
	   ProfileDTO profile = this.profileService.getProfile(email);
	   MemberVO vo = new MemberVO();
	   
	   String TempPw = TempKey.randomPassword();
	   
	   vo.setEmail(email);
	   vo.setPasswd(TempPw);
	   vo.setPhonenumber(phonenumber);
	  
       String contents = new StringBuffer()
    		   			.append("비밀번호 찾기 임시 비밀번호를 알려드립니다.\n\n")
    		   			.append(profile.getNickname() +" 님, 소중한 정보보호를 위하여 ")
    		   			.append("비밀번호는 반드시 정기적으로 변경을 해주시고\n")
    		   			.append("절대 다른 사람이 비밀번호를 알 수 없도록 철저히 관리해주시기 바랍니다.\n\n")
    		   			.append("발급된 비밀번호는 영문 대/소문자 구분하여 입력하셔야 합니다.\n")
    		   			.append("모든 기기에서 로그아웃되며, 발급된 비밀번호로 다시 로그인 후\n")
    		   			.append("사용하시기 바랍니다.\n")
    		   			.append("비밀번호 변경은 내 정보에서 변경하실 수 있습니다.\n ")
    		   			.append("꼭 임시 비밀번호를 변경 후 사용하시기 바랍니다.\n\n")
    		   			.append("고객님의 임시비밀번호는 " + TempPw + " 입니다. \n") 
    		   			.append("동아줄을 이용해 주셔서 감사합니다.")
    		   			.toString();
       
       if(pw != null) {
    	   this.memberservice.memberUpdate(vo);
    	   emailDTO.setContent(contents);
    	   emailDTO.setReceiver(email);
    	   emailDTO.setSubject("[dongazul] " + profile.getNickname() + " 고객님, 발급된 임시 비밀번호를 보내드립니다.");
    	   
           emailSender.SendEmail(emailDTO);
           
          rttrs.addFlashAttribute("msg", "이메일이 발송되었습니다.");
          
           return "redirect:/";
           
       } else {
    	   
    	   rttrs.addFlashAttribute("msg", "가입한 회원이 아닙니다.");
    	   
           return "redirect:/login/findPw";
       } // if-else
   } // findPwPost
   
} // end class
