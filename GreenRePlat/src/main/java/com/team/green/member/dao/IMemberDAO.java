package com.team.green.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.member.dto.MemberDTO;

@Mapper
public interface IMemberDAO {
	int registMember(MemberDTO member);			//	ȸ������
	MemberDTO loginMember(MemberDTO member);	//	�α���
	int updateMember(MemberDTO member);	//	ȸ����������
	String getMember(String memId); // �Ҽ� �α��ο� ���ԉ���� Ȯ��
	MemberDTO socialLoginMember(String memId); 
}
