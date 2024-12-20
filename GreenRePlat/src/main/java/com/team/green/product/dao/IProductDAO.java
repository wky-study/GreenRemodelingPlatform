package com.team.green.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.common.vo.SearchVO;
import com.team.green.product.dto.ProductDTO;

@Mapper
public interface IProductDAO {
	
	// 글 목록 가져오기
	List<ProductDTO> getProductList(SearchVO search);
	
	// 글 총 갯수 가져오기
	int getProductCount(SearchVO search);
	
	// 제품 한개 조회 하기
	ProductDTO getProduct(int no);
	
	// 파일첨부용 조회
	int getProdNo();
	
	// 제품 등록
	int writeProduct(ProductDTO product);
	
	// 제품 삭제
	int deleteProd(int no);
	
}
