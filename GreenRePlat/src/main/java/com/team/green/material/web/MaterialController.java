package com.team.green.material.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

		model.addAttribute("keySearch", search);
		
		model.addAttribute("keyMaterial", materialList);

		return "material/materialView";
	}

	// 제품 글 상세 페이지
	@RequestMapping("/materialDetailView")
	public String materialDetailView(Model model, int no) {

		System.out.println("클릭한 게시글 번호" + no);

		MaterialDTO material = null;
		material = materialService.getMaterial(no);

		System.out.println(material);

		model.addAttribute("keyMaterial", material);

		return "material/materialDetailView";
	}

}
