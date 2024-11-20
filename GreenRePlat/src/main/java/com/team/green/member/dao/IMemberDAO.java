package com.team.green.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.member.dto.MemberDTO;

@Mapper
public interface IMemberDAO {
	int registMember(MemberDTO member);			//	회원가입
	MemberDTO loginMember(MemberDTO member);	//	로그인
	int updateMember(MemberDTO member);	//	회원정보수정
	String getMember(String memId); // 소셜 로그인용 가입됬는지 확인
	MemberDTO socialLoginMember(String memId); 
}
