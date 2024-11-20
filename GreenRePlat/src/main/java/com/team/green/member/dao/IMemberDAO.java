package com.team.green.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.member.dto.MemberDTO;

@Mapper
public interface IMemberDAO {
	int registMember(MemberDTO member);			//	ȸ������
	MemberDTO loginMember(MemberDTO member);	//	�α���
	int updateMember(MemberDTO member);	//	ȸ����������
	
	// ��� ��� ��������
	public List<MemberDTO> getMemList();

}
