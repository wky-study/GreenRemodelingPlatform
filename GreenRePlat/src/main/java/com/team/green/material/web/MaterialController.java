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
	
	
    @RequestMapping("/materialDetailView")
	public String materialView() {
		
		return "material/materialDetailView";
	}
	
}
