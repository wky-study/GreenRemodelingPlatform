package com.team.green.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.member.dao.IMemberDAO;
import com.team.green.member.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	IMemberDAO dao;
	/*	ȸ������
	 * 
	 */
	public int registMember(MemberDTO member) {
		int result = dao.registMember(member);
		return result;
	}
	/*	�α���
	 * 
	 */
	public MemberDTO loginMember(MemberDTO member) {
		MemberDTO result = dao.loginMember(member);
		return result;
	}
	
	/*	ȸ����������(�Ϲ�ȸ��)
	 * 
	 */
	public int updateMember(MemberDTO member) {
		int result = dao.updateMember(member);
		return result;
	}
	
	// �Ҽ� �α��� ���� Ȯ�ο�
	public String getMember(String memId) {
		String result = dao.getMember(memId);
		return result;
	};
	
	public MemberDTO socialLoginMember(String memId) {
		MemberDTO result = dao.socialLoginMember(memId);
		return result;
	}; 
	
}
