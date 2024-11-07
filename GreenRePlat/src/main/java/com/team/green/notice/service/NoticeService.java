package com.team.green.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team.green.notice.dao.INoticeDAO;
import com.team.green.notice.dto.NoticeDTO;

@Service
public class NoticeService {
	
	@Autowired
	INoticeDAO dao;
	
	public List<NoticeDTO> getNoticeList(){
		List<NoticeDTO> result = dao.getNoticeList();
			return result;
	}

}
