package com.team.green.compage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.common.exception.BizNotFoundException;
import com.team.green.common.vo.SearchVO;
import com.team.green.compage.dao.ICompageDAO;
import com.team.green.compage.dto.CompageDTO;

@Service
public class CompageService {

	@Autowired
	ICompageDAO dao;

	// �� ��� ��������
	public List<CompageDTO> getCpList(SearchVO search) {
		List<CompageDTO> result = dao.getCpList(search);
		return result;
	}

	// �� �� ���� ��������
	public int getCpCount(SearchVO search) {
		int result = dao.getCpCount(search);
		return result;
	}

	// �� �Ѱ� ��ȸ �ϱ�
	public CompageDTO getCp(int no) throws BizNotFoundException {
		CompageDTO result = dao.getCp(no);

		if (result == null) {
			throw new BizNotFoundException("�ش� �Խñ��� ��ȣ�� �������� �ʽ��ϴ�.", "API_001");
		}

		return result;
	}

	// �� �ۼ��ϱ�
	public int writeCp(CompageDTO cp) {
		int result = dao.writeCp(cp);
		return result;
	}

	// ����Խñ� ��ȸ�� ������Ʈ
	public int cpCountUp(int no) {
		int result = dao.cpCountUp(no);
		return result;
	}

	// ����Խñ� ����
	public int updateCp(CompageDTO cp) {
		int result = dao.updateCp(cp);
		return result;

	}

	// ���� �Խñ� ����
	public int deleteCp(int cpNo) {
		int result = dao.deleteCp(cpNo);
		return result;
	}
}
