package com.team.green.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.cart.dao.ICartDAO;
import com.team.green.cart.dto.CartDTO;
import com.team.green.product.dto.ProductDTO;

@Service
public class CartService {

	@Autowired
	ICartDAO dao;
	
	// 장바구니에 등록
	public int insertCart(CartDTO cart) {
		int result = dao.insertCart(cart);
		return result;
	};

	// 장바구니 목록
	public List<ProductDTO> getCartList(String memId){
		List<ProductDTO> result = dao.getCartList(memId);
		return result;
	};
	
	// 장바구니 목록 삭제
	public int delCartList(String memId, String cartId) {
		int result = dao.delCartList(memId, cartId);
		return result;
	};
	
}
