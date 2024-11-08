package com.team.green.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.common.exception.BizNotFoundException;
import com.team.green.common.vo.SearchVO;
import com.team.green.notice.dao.INoticeDAO;
import com.team.green.notice.dto.NoticeDTO;
import com.team.green.notice.dao.INoticeDAO;
import com.team.green.notice.dto.NoticeDTO;

@Service
public class NoticeService {
	
	@Autowired
	INoticeDAO dao;

	// 글 목록 가져오기
	public List<NoticeDTO> getNoticeList(SearchVO search){
		List<NoticeDTO> result = dao.getNoticeList(search);
		return result;
	}
	
	// 글 총 갯수 가져오기
	public int getnoticeCount(SearchVO search) {
		int result = dao.getNoticeCount(search);
		return result;
	};
	
	// 글 한개 조회 하기
	public NoticeDTO getnotice(int no) throws BizNotFoundException {
		NoticeDTO result = dao.getnotice(no);
		
		if(result == null) {
			throw new BizNotFoundException("해당 게시글의 번호가 존재하지 않습니다.", "API_001");
		}
		
		return result;
	};
	
	// 글 작성하기
	public int writeNotice(NoticeDTO notice) {
		int result = dao.writeNotice(notice);
		return result;
	};
	
	// 글 조회수 업데이트
	public int noticeCountUp(int no) {
		int result = dao.noticeCountUp(no);
		return result;
	};
	
	// 글 수정
	public int updateNotice(NoticeDTO notice) {
		int result = dao.updateNotice(notice);
		return result;
		
	}
	
	// 글 삭제
	public int deletenotice(int noticeNo) {
		int result = dao.deleteNotice(noticeNo);
		return result;
	};
	
	// 탈퇴 회원 아이디 null 값 변경
	public int noMemIdnotice(String memId) {
		int result = dao.noMemIdNotice(memId);
		return result;
	};

}
