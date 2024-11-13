package com.team.green.material.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.green.material.dto.MaterialDTO;
import com.team.green.material.service.MaterialService;

@Controller
public class MaterialController {
	
	/*자재목록페이지*/
    @RequestMapping("/materialListView")
	public String materialListView() {
		
		return "material/materialListView";
	}
	
    /*자재상세페이지*/
    @RequestMapping("/materialDetailView")
	public String materialDetailView() {
		
		return "material/materialDetailView";
	}
    

	
}
