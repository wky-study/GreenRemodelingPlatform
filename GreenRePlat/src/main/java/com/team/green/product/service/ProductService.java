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
	
	// 글 목록 가져오기
	public List<ProductDTO> getProductList(SearchVO search){
		List<ProductDTO> result = dao.getProductList(search);
		return result;
	}
	
	// 글 총 갯수 가져오기
	public int getProductCount(SearchVO search) {
		int result = dao.getProductCount(search);
		return result;
	};
	
	// 제품 한개 가져오기
	public ProductDTO getProduct(int no) {
		ProductDTO result = dao.getProduct(no);
		return result;
	}
	
	// 파일첨부용 조회
	public int getProdNo() {
		int result = dao.getProdNo();
		return result;
	};
	
	// 제품 등록
	public int writeProduct(ProductDTO product) {
		int result = dao.writeProduct(product);
		return result;
	};
	
	// 제품 삭제
	public int deleteProd(int no) {
		int result = dao.deleteProd(no);
		return result;
	};
	
}
