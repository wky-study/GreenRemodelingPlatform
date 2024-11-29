package com.team.green.material.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.material.SearchM;
import com.team.green.material.dto.MaterialDTO;

@Mapper
public interface IMaterialDAO {
	
	// 글 목록 가져오기
	List<MaterialDTO> getMaterialList(SearchM search);
	
	// 글 총 갯수 가져오기
	int getMaterialCount(SearchM search);
	
	// 자재 한개 조회 하기
	MaterialDTO getMaterial(int no);
	
	// 견적서용 리스트
	List<MaterialDTO> materialList(String itemList);
	
	// 자재 타입별 리스트
	List<MaterialDTO> typeList();
}