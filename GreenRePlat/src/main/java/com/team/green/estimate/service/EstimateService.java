package com.team.green.estimate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.estimate.dao.IEstimateDAO;

@Service
public class EstimateService {
	
	@Autowired
	IEstimateDAO dao;

}
