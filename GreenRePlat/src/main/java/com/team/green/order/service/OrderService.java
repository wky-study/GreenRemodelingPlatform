package com.team.green.order.service;

import java.util.List;

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
	
	// 주문내역 리스트 가져오기
	public List<PaymentDTO> getOrderList(String memId) {
		List<PaymentDTO> result = dao.getOrderList(memId);
		return result;
	};
	
	// 영수증에 보여줄거 한개 가져오기
	public PaymentDTO getReceipt(String partnerOrderId) {
		PaymentDTO result = dao.getReceipt(partnerOrderId);
		return result;
	};
}
