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
	 * Estimate ù ������
	 */
	@RequestMapping("/createEstimation")
	public String createEst() {
		return "estimate/est1";
	}

	/*
	 * Estimate �ι�° ������
	 */
	@RequestMapping("/goEst2")
	public String goEst2() {
		return "estimate/est2";
	}
	
	/*
	 * Estimate ����° ������
	 */
	@RequestMapping("/goEst3")
	public String goEst3() {
		return "estimate/est3";
	}
	
	/*
	 * Estimate �׹�° ������
	 */
	@RequestMapping("/goEst4")
	public String goEst4() {
		return "estimate/est4";
	}
	
	/*
	 * Estimate ������ ������
	 */
	@RequestMapping("/goEstFinal")
	public String goEstFinal() {
		return "estimate/estFinal";
	}

}
