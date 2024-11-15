package com.team.green.notice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.team.green.common.vo.SearchVO;
import com.team.green.notice.dto.NoticeDTO;

@Mapper
public interface INoticeDAO {
	// ���� �Խ��� �� ��� ��������
	List<NoticeDTO> getNoticeList(SearchVO search);
	
	// ���� �Խ��� �� �� ���� ��������
	int getNoticeCount(SearchVO search);
	
	// ���� �Խñ� �Ѱ� ��ȸ �ϱ�
	NoticeDTO getNotice(int no);
	
	// ���� �Խñ� �ۼ��ϱ�
	int writeNotice(NoticeDTO notice);
	
	// ���� �Խñ� ��ȸ�� ������Ʈ
	int noticeCountUp(int no);
	
	// ���� �Խñ� ����
	int updateNotice(NoticeDTO notice);
	
	// ���� �Խñ� ����
	int noticeDeleteDo(int noticeNo);
	
	// Ż�� ȸ�� ���̵� null �� ����
	int noMemIdNotice(String memId);
	
	// �Խñ� ��ȣ ��ȸ
	int getNoticeNo();
	

}
