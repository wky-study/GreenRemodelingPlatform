package com.team.green.material.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.material.dao.IMaterialDAO;
import com.team.green.material.dto.MaterialDTO;
	
@Service
public class MaterialService {
	
	@Autowired
	IMaterialDAO dao;

	public List<MaterialDTO> getMaterialList(){
		List<MaterialDTO> result = dao.getMaterialList();
		return result;
	}
	
}
