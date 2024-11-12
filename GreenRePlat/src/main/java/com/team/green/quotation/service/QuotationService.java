package com.team.green.quotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.quotation.dao.IQuotationDAO;

@Service
public class QuotationService {
	
	@Autowired
	IQuotationDAO dao;

}
