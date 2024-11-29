package com.team.green.material.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.material.SearchM;
import com.team.green.material.dao.IMaterialDAO;
import com.team.green.material.dto.MaterialDTO;

@Service
public class MaterialService {

	@Autowired
	IMaterialDAO dao;

	// �� ��� ��������
	public List<MaterialDTO> getMaterialList(SearchM search){
		List<MaterialDTO> result = dao.getMaterialList(search);
		return result;
	}
	
	// �� �� ���� ��������
	public int getMaterialCount(SearchM search) {
		int result = dao.getMaterialCount(search);
		return result;
	};
	
	// ���� �Ѱ� ��������
	public MaterialDTO getMaterial(int no) {
		MaterialDTO result = dao.getMaterial(no);
		return result;
	}
	
	// �������� ����Ʈ
	public List<MaterialDTO> materialList(String itemList){
		List<MaterialDTO> result = dao.materialList(itemList);
		return result;
	};
	
	// ���� Ÿ�Ժ� ����Ʈ
	public List<MaterialDTO> typeList(){
		List<MaterialDTO> result = dao.typeList();
		return result;
	};
	
}
