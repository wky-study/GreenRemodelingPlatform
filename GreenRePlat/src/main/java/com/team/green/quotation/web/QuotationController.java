package com.team.green.quotation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.team.green.quotation.service.QuotationService;


@Controller
public class QuotationController {
	@Autowired
	QuotationService quoSvc;

}
