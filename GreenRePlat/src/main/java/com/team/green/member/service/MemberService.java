package com.team.green.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.member.dao.IMemberDAO;
import com.team.green.member.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	IMemberDAO dao;
	/*	회원가입
	 * 
	 */
	public int registMember(MemberDTO member) {
		int result = dao.registMember(member);
		return result;
	}
	/*	로그인
	 * 
	 */
	public MemberDTO loginMember(MemberDTO member) {
		MemberDTO result = dao.loginMember(member);
		return result;
	}
	
	/*	회원정보수정(일반회원)
	 * 
	 */
	public int updateMember(MemberDTO member) {
		int result = dao.updateMember(member);
		return result;
	}
	
	public List<MemberDTO> getMemList(){
		List<MemberDTO> result = dao.getMemList();
		return result;
	}
	public MemberDTO searchMember(String member) {
		MemberDTO result = dao.searchMember(member);
		return result;
	}

}
