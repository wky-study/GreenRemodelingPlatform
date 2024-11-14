package com.team.green.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.order.dto.PaymentDTO;

@Mapper
public interface IOrderDAO {

	// ���� �Ϸ� �� �� ��ǰ�� ���� ���
	int insertOrder(PaymentDTO payment);
	
	// �ֹ����� ����Ʈ ��������
	List<PaymentDTO> getOrderList(String memId);
	
	// �������� �����ٰ� �Ѱ� ��������
	PaymentDTO getReceipt(String partnerOrderId);
}
