package com.team.green.attach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.attach.dao.IAttachDAO;
import com.team.green.attach.dto.AttachDTO;

@Service
public class AttachService {

	
	@Autowired
	IAttachDAO dao;
	
	
	public int insertAttach(AttachDTO attach) {
		int result = dao.insertAttach(attach);
		return result;
	};
	
	public List<AttachDTO> getAttachList(int atchNoticeNo){
		List<AttachDTO> result = dao.getAttachList(atchNoticeNo);
		return result;
	};
	
	public int insertProdAttach(AttachDTO attach) {
		int result = dao.insertProdAttach(attach);
		return result;
	};
	
	public List<AttachDTO> getProdAttachList(int prodNo){
		List<AttachDTO> result = dao.getProdAttachList(prodNo);
		return result;
	};
	
	
	
}
