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

	// �� ��� ��������
	public List<NoticeDTO> getNoticeList(SearchVO search){
		return dao.getNoticeList(search);
	}
	
	// �� �� ���� ��������
	public int getNoticeCount(SearchVO search) {
		return dao.getNoticeCount(search);
	}
	
	// �� �� �� ��ȸ�ϱ�
	public NoticeDTO getNotice(int no) throws BizNotFoundException {
		NoticeDTO result = dao.getNotice(no);
		
		if(result == null) {
			throw new BizNotFoundException("�ش� �Խñ��� ��ȣ�� �������� �ʽ��ϴ�.", "API_001");
		}
		
		return result;
	}
	
	// �� �ۼ��ϱ�
	public int writeNotice(NoticeDTO notice) {
		return dao.writeNotice(notice);
	}
	
	// �� ��ȸ�� ������Ʈ
	public int noticeCountUp(int no) {
		return dao.noticeCountUp(no);
	}
	
	// �� ����
	public int updateNotice(NoticeDTO notice) {
		return dao.updateNotice(notice);
	}
	
	// �� ����
	public int noticeDeleteDo(int noticeNo) {
		return dao.noticeDeleteDo(noticeNo);
	}
	
	// Ż�� ȸ�� ���̵� null �� ����
	public int noMemIdNotice(String memId) {
		return dao.noMemIdNotice(memId);
	}
}
