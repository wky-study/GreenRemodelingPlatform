package com.team.green.cart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.team.green.cart.dto.CartDTO;
import com.team.green.product.dto.ProductDTO;

@Mapper
public interface ICartDAO {

	// ��ٱ��� ���
	int insertCart(CartDTO cart);
	
	// ��ٱ��� ���
	List<ProductDTO> getCartList(String memId);
	
	// ��ٱ��� ��� ����
    int delCartList(@Param("memId") String memId, @Param("cartId") String cartId);

	
}
