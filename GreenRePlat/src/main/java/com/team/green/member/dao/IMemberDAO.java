package com.team.green.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.member.dto.MemberDTO;

@Mapper
public interface IMemberDAO {

	int registMember(MemberDTO member);
	MemberDTO loginMember(MemberDTO member);
	int updateMember(MemberDTO member);
	MemberDTO searchMember(String member);


	String getMember(String memId);
	MemberDTO socialLoginMember(String memId); 

	

	public List<MemberDTO> getMemList();


}
