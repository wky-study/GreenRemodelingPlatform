package com.team.green.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.order.dto.PaymentDTO;

@Mapper
public interface IOrderDAO {

	// 결제 완료 시 각 상품별 정보 등록
	int insertOrder(PaymentDTO payment);
	
	// 주문내역 리스트 가져오기
	List<PaymentDTO> getOrderList(String memId);
	
	// 영수증에 보여줄거 한개 가져오기
	PaymentDTO getReceipt(String partnerOrderId);
}
