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
	public int registMember(MemberDTO member) {
		int result = dao.registMember(member);
		return result;
	}
	public MemberDTO loginMember(MemberDTO member) {
		MemberDTO result = dao.loginMember(member);
		return result;
	}
	
	public int updateMember(MemberDTO member) {
		int result = dao.updateMember(member);
		return result;
	}
	

	public String getMember(String memId) {
		String result = dao.getMember(memId);
		return result;
	};
	
	public MemberDTO socialLoginMember(String memId) {
		MemberDTO result = dao.socialLoginMember(memId);
		return result;
	}; 
	

	public List<MemberDTO> getMemList(){
		List<MemberDTO> result = dao.getMemList();
		return result;
	}
	public MemberDTO searchMember(String member) {
		MemberDTO result = dao.searchMember(member);
		return result;
	}
	
    // ID 중복 확인
    public boolean checkIdDuplication(String memId) {
        int count = dao.checkIdDuplication(memId);
        return count == 0;  // 중복되지 않으면 true
    }

    // 닉네임 중복 확인
    public boolean checkNickDuplication(String memNick) {
        int count = dao.checkNickDuplication(memNick);
        return count == 0;  // 중복되지 않으면 true
    }
    
    // 비밀번호 확인
    public boolean checkPasswordMatch(String memPw, String memRn) {
        return memPw.equals(memRn);  // 비밀번호와 확인용 비밀번호가 같으면 true
    }

}
