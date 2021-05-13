package com.dongazul.myapp.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.dongazul.myapp.domain.LoginDTO;
import com.dongazul.myapp.domain.MemberVO;

public interface MemberMapper {
	// 회원가입
	public abstract void insert(MemberVO vo) throws Exception;
	
	// 로그인
	public abstract MemberVO select(LoginDTO dto) throws Exception;
	
	// 이메일 중복체크
	public abstract int emailCheck(MemberVO vo) throws Exception;
	
	//회원 정보 수정
	public abstract void memberUpdate(MemberVO vo) throws Exception;
	
	// 회원탈퇴
	public abstract void memberDelete(MemberVO vo) throws Exception;
	
	// 이메일 찾기(조회)
	public abstract String findId(Integer phonenumber) throws Exception;
	
	// 비밀번호 찾기
	public abstract String findPw(
			@Param("email") String email,
			@Param("phonenumber") Integer phonenumber) throws Exception;
	
	// 자동로그인 기능이 on 되어있는 경우, 이 정보(자동로그인)를 업데이트.
	public abstract int updateMemberWithRememberMe(
				@Param("email") String email,
				@Param("rememberme")String rememberme,
				@Param("rememberage")Date rememberage
				) throws Exception;
		
	// 자동로그인 쿠키값(=세션ID)으로 사용자를 찾기
	public abstract MemberVO selectMemberWithRememberMe(String rememberme)
			throws Exception;
	
	// 이메일 중복체크
	public abstract int passwdCheck(String passwd) throws Exception;
	
} // interface
