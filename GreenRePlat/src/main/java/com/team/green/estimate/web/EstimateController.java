package com.team.green.estimate.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.green.estimate.service.EstimateService;

@Controller
public class EstimateController {

	@Autowired
	EstimateService estSvc;

	/*
	 * Estimate 첫 페이지
	 */
	@RequestMapping("/createEstimation")
	public String createEst() {
		return "estimate/est1";
	}

	/*
	 * Estimate 두번째 페이지
	 */
	@RequestMapping("/goEst2")
	public String goEst2() {
		return "estimate/est2";
	}
	
	/*
	 * Estimate 세번째 페이지
	 */
	@RequestMapping("/goEst3")
	public String goEst3() {
		return "estimate/est3";
	}
	
	/*
	 * Estimate 네번째 페이지
	 */
	@RequestMapping("/goEst4")
	public String goEst4() {
		return "estimate/est4";
	}
	
	/*
	 * Estimate 마지막 페이지
	 */
	@RequestMapping("/goEstFinal")
	public String goEstFinal() {
		return "estimate/estFinal";
	}

}
