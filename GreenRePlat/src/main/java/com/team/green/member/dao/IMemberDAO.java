package com.team.green.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.member.dto.MemberDTO;

@Mapper
public interface IMemberDAO {
	int registMember(MemberDTO member);			//	회원가입
	MemberDTO loginMember(MemberDTO member);	//	로그인

}
