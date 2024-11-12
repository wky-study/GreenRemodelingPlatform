package com.team.green.notice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team.green.common.exception.BizNotFoundException;
import com.team.green.common.vo.SearchVO;
import com.team.green.notice.dao.INoticeDAO;
import com.team.green.notice.dto.NoticeDTO;

@Service
public class NoticeService {
	
	@Autowired
	INoticeDAO dao;

	// 글 목록 가져오기
	public List<NoticeDTO> getNoticeList(SearchVO search){
		return dao.getNoticeList(search);
	}
	
	// 글 총 갯수 가져오기
	public int getNoticeCount(SearchVO search) {
		return dao.getNoticeCount(search);
	}
	
	// 글 한 개 조회하기
	public NoticeDTO getNotice(int no) throws BizNotFoundException {
		NoticeDTO result = dao.getNotice(no);
		
		if(result == null) {
			throw new BizNotFoundException("해당 게시글의 번호가 존재하지 않습니다.", "API_001");
		}
		
		return result;
	}
	
	// 글 작성하기
	public int writeNotice(NoticeDTO notice) {
		return dao.writeNotice(notice);
	}
	
	// 글 조회수 업데이트
	public int noticeCountUp(int no) {
		return dao.noticeCountUp(no);
	}
	
	// 글 수정
	public int updateNotice(NoticeDTO notice) {
		return dao.updateNotice(notice);
	}
	
	// 글 삭제
	public int noticeDeleteDo(int noticeNo) {
		return dao.noticeDeleteDo(noticeNo);
	}
	
	// 탈퇴 회원 아이디 null 값 변경
	public int noMemIdNotice(String memId) {
		return dao.noMemIdNotice(memId);
	}
}
