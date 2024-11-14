package com.team.green.material.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.material.dao.IMaterialDAO;

public class MaterialService {
	
@Service
public class MaterialServie {
	
	@Autowired
	IMaterialDAO dao;
	/*
	public List<MaterialDTO> getMaterialList(){
		List<MaterialDTO> result = dao.getMaterialList();
		return result;
	}
	*/
}


}