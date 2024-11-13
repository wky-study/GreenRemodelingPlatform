package com.team.green.order.dao;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.order.dto.PaymentDTO;

@Mapper
public interface IOrderDAO {

	// 결제 완료 시 각 상품별 정보 등록
	int insertOrder(PaymentDTO payment);
	
}
