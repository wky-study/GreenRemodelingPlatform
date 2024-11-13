package com.team.green.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.order.dao.IOrderDAO;
import com.team.green.order.dto.PaymentDTO;

@Service
public class OrderService {

	@Autowired
	IOrderDAO dao;
	
	public int insertOrder(PaymentDTO payment) {
		int result = dao.insertOrder(payment);
		return result;
	};
}
