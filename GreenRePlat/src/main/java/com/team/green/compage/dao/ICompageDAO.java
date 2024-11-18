package com.team.green.compage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.common.vo.SearchVO;
import com.team.green.compage.dto.CompageDTO;

@Mapper
public interface ICompageDAO {
	// ���� �Խ��� �� ��� ��������
		List<CompageDTO> getCpList(SearchVO search);
		
		// ���� �Խ��� �� �� ���� ��������
		int getCpCount(SearchVO search);
		
		// ���� �Խñ� �Ѱ� ��ȸ �ϱ�
		CompageDTO getCp(int no);
		
		// ���� �Խñ� �ۼ��ϱ�
		int writeCp(CompageDTO cp);
		
		// ���� �Խñ� ��ȸ�� ������Ʈ
		int cpCountUp(int no);
		
		// ���� �Խñ� ����
		int updateCp(CompageDTO cp);
		
		// ���� �Խñ� ����
		int deleteCp(int cpNo);
		
}
