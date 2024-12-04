package com.team.green.cart.web;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.green.cart.dto.CartDTO;
import com.team.green.cart.service.CartService;
import com.team.green.common.util.MyUtil;
import com.team.green.member.dto.MemberDTO;
import com.team.green.product.dto.ProductDTO;


@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	
	@RequestMapping("/cartView")
	public String cartView(HttpSession session) {
		
		MemberDTO member = (MemberDTO)session.getAttribute("memInfo");
		if (member == null) {
			return "redirect:/loginView";
		}
		String memId = member.getMemId();
		System.out.println(memId);
		
		// ȸ�� ��ٱ��� ��� ��������
		List<ProductDTO> prod = cartService.getCartList(memId); 
		
		System.out.println(prod);
		
		session.setAttribute("keyProd", prod);
		
		
		return "cart/cartView";
	}
	
	
	@PostMapping("/addToCart")
	public String addToCart(CartDTO cart) {
		
		String uniqueId = MyUtil.makeUniqueId();
		cart.setCartId(uniqueId);
		
		System.out.println(cart);
		
		String resp = "success";
		
		int cnt = cartService.insertCart(cart);
		
		System.out.println(cnt);
		
		if(cnt == 0) {
			resp = "fail";
		}
		 
		return resp;
	}
	
	@ResponseBody
	@PostMapping("/removeFromCart")
	public String removeFromCart(@RequestBody HashMap<String, Object> cartData ) {
	   
	    String memId = (String) cartData.get("memId");
	    List<String> cartIds = (List<String>) cartData.get("cartId");
		
	    System.out.println("ȸ�� ���̵�: " + memId);
	    System.out.println("������ ��ǰ ��ȣ��: " + cartIds);
	    
	    String resp = "success";  // �⺻ ���� ����
	    int cnt = 0;  // ������ �׸� ��
	    
	    for(int i = 0; i < cartIds.size(); i++) {
	    	cnt += cartService.delCartList(memId, cartIds.get(i));  
	    }
	    
	    
	    if(cnt == 0) {
	        resp = "fail";
	    }
	    
	    System.out.println(cnt);
		
	    System.out.println(resp);
	    
		return resp;
	}
	
	
}
