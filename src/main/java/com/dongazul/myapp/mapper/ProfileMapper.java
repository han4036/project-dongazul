package com.dongazul.myapp.mapper;

import java.util.List;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.ProfileDTO;

public interface ProfileMapper {
	
	// 프로필 생성(profile)
	public abstract boolean insertProfile(ProfileDTO dto) throws Exception;
	
	// 프로필 생성(interests)
	public abstract boolean insertInterests(ProfileDTO dto) throws Exception;
	
	// 프로필 조회
	public abstract ProfileDTO selectProfile(String email) throws Exception;
	
	// 프로필 수정(profile)
	public abstract int updateProfile(ProfileDTO dto) throws Exception;
	
	// 프로필 수정(interests)
	public abstract int updateInterest(ProfileDTO dto) throws Exception;
	
	
	// 프로필 전체목록 가져오기
	public abstract List<ProfileDTO> selectProfileWithThem() throws Exception;
} // end class
