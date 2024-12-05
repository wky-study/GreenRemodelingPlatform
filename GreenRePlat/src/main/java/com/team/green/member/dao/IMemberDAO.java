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
	
    // ID 중복 확인
    int checkIdDuplication(String memId); 

    // 닉네임 중복 확인
    int checkNickDuplication(String memNick);
    
    // 기업 회원 리스트 불러오기
    List<MemberDTO> getComList();
    
    // 기업 회원 아이디 찾기
    String getComId(String memName);
    
    // 회원 정보 조회
    MemberDTO getMemInfo(String memId);
    
}

