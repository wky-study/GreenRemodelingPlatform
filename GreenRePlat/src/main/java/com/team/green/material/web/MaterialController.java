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

import com.team.green.material.SearchM;
import com.team.green.material.dto.MaterialDTO;
import com.team.green.material.service.MaterialService;

@Controller
public class MaterialController {

	/* 서비스에서 불러오기 */
	@Autowired
	MaterialService materialService;

	/* 자재목록페이지 */
	@RequestMapping("/materialView")
	public String materialListView(Model model, SearchM search) {

		int materialCount = materialService.getMaterialCount(search);
		// DB로 부터 가져온 전체 게시글의 수를 search의 필드변수에 넣어줌
		search.setMaterialCount(materialCount);
		search.setting();

		List<MaterialDTO> materialList = materialService.getMaterialList(search);

		System.out.println(search);
		System.out.println(materialList);

		model.addAttribute("keymaterial, materialList");

		model.addAttribute("keySearch", search);

		return "material/materialView";
	}

	/* 자재상세페이지 */
	@RequestMapping("/materialDetailView")
	public String materialDetailView() {

		return "material/materialDetailView";
	}

}
