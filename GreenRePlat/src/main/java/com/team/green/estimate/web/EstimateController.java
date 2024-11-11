package com.team.green.estimate.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.team.green.estimate.service.EstimateService;

@Controller
public class EstimateController {
	
	@Autowired
	EstimateService estSvc;

}
