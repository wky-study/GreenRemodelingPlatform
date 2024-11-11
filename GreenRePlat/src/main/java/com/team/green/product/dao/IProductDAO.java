package com.team.green.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.common.vo.SearchVO;
import com.team.green.product.dto.ProductDTO;

@Mapper
public interface IProductDAO {
	
	// �� ��� ��������
	List<ProductDTO> getProductList(SearchVO search);
	
	// �� �� ���� ��������
	int getProductCount(SearchVO search);
	
	
}
