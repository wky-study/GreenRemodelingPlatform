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

	/* ���񽺿��� �ҷ����� */
	@Autowired
	MaterialService materialService;

	/* ������������ */
	@RequestMapping("/materialView")
	public String materialListView(Model model, SearchM search) {

		int materialCount = materialService.getMaterialCount(search);
		// DB�� ���� ������ ��ü �Խñ��� ���� search�� �ʵ庯���� �־���
		search.setMaterialCount(materialCount);
		search.setting();

		List<MaterialDTO> materialList = materialService.getMaterialList(search);

		System.out.println(search);
		System.out.println(materialList);

		model.addAttribute("keySearch", search);
		
		model.addAttribute("keyMaterial", materialList);

		return "material/materialView";
	}

	// ��ǰ �� �� ������
	@RequestMapping("/materialDetailView")
	public String materialDetailView(Model model, int no) {

		System.out.println("Ŭ���� �Խñ� ��ȣ" + no);

		MaterialDTO material = null;
		material = materialService.getMaterial(no);

		System.out.println(material);

		model.addAttribute("keyMaterial", material);

		return "material/materialDetailView";
	}

}
