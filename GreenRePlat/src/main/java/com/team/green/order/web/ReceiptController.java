package com.team.green.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceiptController {
	
	@RequestMapping("/receiptView")
	public String receiptView() {
		
		
		
		return "order/receiptView";
	};
}
