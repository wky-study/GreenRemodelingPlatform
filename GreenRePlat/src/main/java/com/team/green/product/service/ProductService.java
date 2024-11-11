package com.team.green.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.common.vo.SearchVO;
import com.team.green.product.dao.IProductDAO;
import com.team.green.product.dto.ProductDTO;


@Service
public class ProductService {
	
	@Autowired
	IProductDAO dao;
	
	// �� ��� ��������
	public List<ProductDTO> getProductList(SearchVO search){
		List<ProductDTO> result = dao.getProductList(search);
		return result;
	}
	
	// �� �� ���� ��������
	public int getProductCount(SearchVO search) {
		int result = dao.getProductCount(search);
		return result;
	};
	
	// ��ǰ �Ѱ� ��������
	public ProductDTO getProduct(int no) {
		ProductDTO result = dao.getProduct(no);
		return result;
	}
	
}
