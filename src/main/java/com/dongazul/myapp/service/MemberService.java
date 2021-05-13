package com.dongazul.myapp.service;

import java.util.Date;

import com.dongazul.myapp.domain.LoginDTO;
import com.dongazul.myapp.domain.MemberVO;

public interface MemberService {
	//회원가입
	public void signUp(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO signIn(LoginDTO dto) throws Exception;
	
	//이메일 중복 체크
	public int emailCheck(MemberVO vo) throws Exception;
	
	// 회원 정보 수정
	public void memberUpdate(MemberVO vo) throws Exception;
	
	// 회원탈퇴
	public void memberDelete(MemberVO vo) throws Exception;
	
	// 아이디 찾기
	public String findId(Integer phonenumber) throws Exception;
	
	// 비밀번호 찾기
	public abstract String findPw(
					String email,
					Integer phonenumber
					) throws Exception;
 
	// 자동로그인 기능이 on 되어있는 경우, 이 정보(자동로그인)를 업데이트.
	public abstract void updateMemberWithRememberMe(
					String email, 
					String rememberme, 
					Date rememberage
					) throws Exception;
			
	// 자동로그인 쿠키값(=세션ID)으로 사용자를 찾기
	public abstract MemberVO selectMemberWithRememberMe(String rememberme)
				throws Exception;
	
	// 이메일 중복체크
	public abstract int passwdCheck(String passwd) throws Exception;
} // end class
