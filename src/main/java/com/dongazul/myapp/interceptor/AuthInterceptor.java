package com.dongazul.myapp.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.dongazul.myapp.controller.LoginController;
import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.service.MemberService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Component
public class AuthInterceptor
	implements HandlerInterceptor {
	
	public static final String loginKey = LoginController.loginKey;	
	public static final String rememberMeKey = "__REMEMBER_ME__";
	public static final String requestURIKey = "__REQUEST_URI__";
	public static final String queryStringKey = "__QUERYSTRING__";
	
	@Setter(onMethod_=@Autowired)
	private MemberService service;
	
	@Override
	public boolean preHandle(
			HttpServletRequest req, 
			HttpServletResponse res, 
			Object handler) throws Exception {
		
		log.debug("==================================================");
		log.debug("preHandle(req, res, handler) invoked.");
		log.debug("==================================================");
		
		HttpSession session = req.getSession();
		MemberVO signIn = (MemberVO)session.getAttribute(loginKey);
		
		if (signIn == null) {
			log.info("\t+ NOT logged in yet.");
			
			this.saveDestination(req);
			
			Cookie rememberMeCookie = 
					WebUtils.getCookie(req, rememberMeKey);
			
			log.info("\t+ rememberMeCookie: " + rememberMeCookie);
			
			if (rememberMeCookie != null) {	
				String rememberme = rememberMeCookie.getValue();
				log.info("\t+ rememberMe: " + rememberme);
				
				signIn = this.service.selectMemberWithRememberMe(rememberme);
				log.info("\t+ user: " + signIn);
				
				if (signIn != null) {	
					session.setAttribute(loginKey, signIn);
					
					return true;
				} // if
			} // if
		 
			res.sendRedirect("/");
			
			log.info("\t+ Redirected into /");

			return false;
		} // if
		
		log.info("\t+ Already logged in.");
		log.info("\t+ signIn: " + signIn);
		
		return true;
	} // preHandle
	
	// 사용자가 원래 요청한 URI를 문자열로 만들어 Session Scope에 저장
	private void saveDestination(HttpServletRequest req) {
		
		log.debug("saveDestination(req) invoked.");
		
		String originRequestURI = req.getRequestURI();
		String originQueryString = req.getQueryString();
	
		HttpSession session = req.getSession();
		
		session.setAttribute(requestURIKey, originRequestURI);
		session.setAttribute(queryStringKey, originQueryString);
	} // saveDestination

} // end class
