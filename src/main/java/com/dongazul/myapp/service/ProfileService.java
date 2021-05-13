package com.dongazul.myapp.service;

import java.util.List;

import com.dongazul.myapp.domain.ProfileDTO;

public interface ProfileService {
	
	// 프로필 생성
	public abstract void craeteProfile(ProfileDTO dto) throws Exception;
	
	// 프로필 조회
	public abstract ProfileDTO getProfile(String email) throws Exception;
	
	// 프로필 수정
	public abstract void modifyProfile(ProfileDTO dto) throws Exception;
	
	//프로필 목록 전체 가져오기
	public abstract List<ProfileDTO> selectProfileWithThem() throws Exception;

} // end interface
