package com.team.green.compage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.compage.dto.CompageDTO;
import com.team.green.material.SearchM;

@Mapper
public interface ICompageDAO {
	
		// ��� ��������
		List<CompageDTO> getCpList(SearchM search);
		
		// �Խ��� �� �� ���� ��������
		int getCpCount(SearchM search);
		
		// �Խñ� �Ѱ� ��ȸ �ϱ�
		CompageDTO getCp(int no);
		
		// �Խñ� �ۼ��ϱ�
		int writeCp(CompageDTO cp);
		
		// �Խñ� ��ȸ�� ������Ʈ
		int cpCountUp(int no);
		
		// �Խñ� ����
		int updateCp(CompageDTO cp);
		
		// �Խñ� ����
		int deleteCp(int cpNo);
		
}
