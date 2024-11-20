package com.team.green.material.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.material.SearchM;
import com.team.green.material.dto.MaterialDTO;

@Mapper
public interface IMaterialDAO {
	
	// �� ��� ��������
	List<MaterialDTO> getMaterialList(SearchM search);
	
	// �� �� ���� ��������
	int getMaterialCount(SearchM search);
	
	// ���� �Ѱ� ��ȸ �ϱ�
	MaterialDTO getMaterial(int no);
	
}