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

	// �� ��� ��������
	public List<NoticeDTO> getNoticeList(SearchVO search){
		List<NoticeDTO> result = dao.getNoticeList(search);
		return result;
	}
	
	// �� �� ���� ��������
	public int getNoticeCount(SearchVO search) {
		int result = dao.getNoticeCount(search);
		return result;
	}
	
	// �� �Ѱ� ��ȸ �ϱ�
	public NoticeDTO getNotice(int no) throws BizNotFoundException {
		NoticeDTO result = dao.getnotice(no);
		
		if(result == null) {
			throw new BizNotFoundException("�ش� �Խñ��� ��ȣ�� �������� �ʽ��ϴ�.", "API_001");
		}
		
		return result;
	}
	
	// �� �ۼ��ϱ�
	public int writeNotice(NoticeDTO notice) {
		int result = dao.writeNotice(notice);
		return result;
	}
	
	// �� ��ȸ�� ������Ʈ
	public int noticeCountUp(int no) {
		int result = dao.noticeCountUp(no);
		return result;
	}
	
	// �� ����
	public int updateNotice(NoticeDTO notice) {
		int result = dao.updateNotice(notice);
		return result;
		
	}
	
	// �� ����
	public int noticeDeleteDo(int noticeNo) {
		int result = dao.noticeDeleteDo(noticeNo);
		return result;
	}
	
	// Ż�� ȸ�� ���̵� null �� ���� - �������� �Խ��ǿ��� ������ҰŰ���
	public int noMemIdnotice(String memId) {
		int result = dao.noMemIdNotice(memId);
		return result;
	}

}
