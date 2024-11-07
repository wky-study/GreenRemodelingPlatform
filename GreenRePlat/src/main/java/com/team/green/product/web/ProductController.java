package com.team.green.product.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.green.common.vo.SearchVO;
import com.team.green.product.dto.ProductDTO;
import com.team.green.product.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
    @RequestMapping("/productView")
	public String productView(Model model, SearchVO search) {
    	
		int productCount = productService.getProductCount(search);
		// DB�� ���� ������ ��ü �Խñ��� ���� search�� �ʵ庯���� �־���
		search.setProdCount(productCount);
		search.setting();
		
		List<ProductDTO> productList = productService.getProductList(search);
		
		System.out.println(search);
		System.out.println(productList);
		
		model.addAttribute("keyProduct",productList);
		
		model.addAttribute("keySearch", search);
		
		return "product/productView";
	}
	
}
