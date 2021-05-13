package com.dongazul.myapp.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dongazul.myapp.controller.LoginController;
import com.dongazul.myapp.controller.ProfileController;
import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.ProfileDTO;
import com.dongazul.myapp.service.ProfileService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor	

@Component
public class LoginInterceptor
	implements HandlerInterceptor {
	
	private static final String loginKey = LoginController.loginKey;	
	private static final String rememberMeKey = "__REMEMBER_ME__";
	private static final String profileKey = ProfileController.profileKey;
	
	private static final String requestURIKey = AuthInterceptor.requestURIKey;
	private static final String queryStringKey = AuthInterceptor.queryStringKey;
	
	@Setter(onMethod_= {@Autowired})
	private ProfileService service;
	
	@Override
	public boolean preHandle(
			HttpServletRequest req, 
			HttpServletResponse res, 
			Object handler) throws Exception {
		
		log.debug("==================================================");
		log.debug("preHandle(req, res, handler) invoked.");
		log.debug("==================================================");

		HttpSession mySession = req.getSession();

		mySession.removeAttribute(loginKey);
		
		log.info("\t+ 이전의 로그인했다라는 증표가 삭제되었습니다.");
		
		return true;
	} // preHandle
	
	@Override
	public void postHandle(
			HttpServletRequest req, 
			HttpServletResponse res, 
			Object handler,
			ModelAndView modelAndView
			) throws Exception {
		log.debug("==================================================");
		log.debug("postHandle(req, res, handler, modelAndView) invoked.");
		log.debug("==================================================");
		
		HttpSession mySession = req.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
		MemberVO signIn = (MemberVO) modelMap.get(loginKey);
		
		if(signIn != null) {
			
			ProfileDTO profile = this.service.getProfile( signIn.getEmail() );

			mySession.setAttribute(loginKey, signIn);
			
			log.info("\t+ 정상적으로 로그인했다라는 증표를 저장했습니다.");
			
			String isRememberMe = req.getParameter("rememberme");
			
			if (isRememberMe != null) {			
				
				String mySessionId = mySession.getId();
				
				Cookie rememberMeCookie = 
					new Cookie(rememberMeKey, mySessionId);
				
				rememberMeCookie.setMaxAge(60 * 60 * 24 * 7);	
				rememberMeCookie.setPath("/");
				
				res.addCookie(rememberMeCookie);
				
				log.info("\t+ rememberMeCookie: " + rememberMeCookie);
				log.info("\t+ 응답문서 헤더에, 자동로그인 쿠키설정 완료");
			} // Remember-Me 기능을 on 시켰다면...
			
			if(profile == null) {
				res.sendRedirect("/profile/create");
			} else {
				
				mySession.setAttribute(profileKey, profile);
				
			}
			
			String originRequestURI = 
				(String) mySession.getAttribute(requestURIKey);
			
			String originQueryString = 
					(String) mySession.getAttribute(queryStringKey);
			
			if(originRequestURI != null) { 

				String originRequest = originRequestURI+(
						(originQueryString != null && 
						 !"".equals(originQueryString))? 
								 "?"+originQueryString : ""
					);
				
					res.sendRedirect(originRequest);
					
					log.info("\t+ origin URI로 리다이렉션 수행..");
					log.info("\t\t : " + originRequest);
			} else { 

					res.sendRedirect("/matching/swipe");
					
					log.info("\t+ Redirectd into /matching/swipe ....");
			} // if-else
			
		} else {
			
			log.info("\t+ Redirected into /");
			
			res.sendRedirect("/");
		}
	} // postHandle
	
} // end class
