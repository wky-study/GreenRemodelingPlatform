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

	// 글 목록 가져오기
	public List<MaterialDTO> getMaterialList(SearchM search){
		List<MaterialDTO> result = dao.getMaterialList(search);
		return result;
	}
	
	// 글 총 갯수 가져오기
	public int getMaterialCount(SearchM search) {
		int result = dao.getMaterialCount(search);
		return result;
	};
	
	// 자재 한개 가져오기
	public MaterialDTO getMaterial(int no) {
		MaterialDTO result = dao.getMaterial(no);
		return result;
	}
	
	// 견적서용 리스트
	public List<MaterialDTO> materialList(String itemList){
		List<MaterialDTO> result = dao.materialList(itemList);
		return result;
	};
	
	// 자재 타입별 리스트
	public List<MaterialDTO> typeList(){
		List<MaterialDTO> result = dao.typeList();
		return result;
	};
	
}
