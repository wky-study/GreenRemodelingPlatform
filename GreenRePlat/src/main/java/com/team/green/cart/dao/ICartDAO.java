package com.team.green.cart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.team.green.cart.dto.CartDTO;
import com.team.green.product.dto.ProductDTO;

@Mapper
public interface ICartDAO {

	// 장바구니 등록
	int insertCart(CartDTO cart);
	
	// 장바구니 목록
	List<ProductDTO> getCartList(String memId);
	
	// 장바구니 목록 삭제
    int delCartList(@Param("memId") String memId, @Param("cartId") String cartId);

	
}
