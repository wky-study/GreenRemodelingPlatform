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

import com.team.green.attach.dto.AttachDTO;
import com.team.green.material.SearchM;
import com.team.green.material.dto.MaterialDTO;
import com.team.green.material.service.MaterialService;
import com.team.green.product.dto.ProductDTO;

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

		model.addAttribute("keymaterial, materialList");

		model.addAttribute("keySearch", search);

		return "material/materialView";
	}

	// ��ǰ �� �� ������
	@RequestMapping("/materialDetailView")
	public String materialDetailView(Model model, int id) {

		System.out.println("Ŭ���� �Խñ� ��ȣ" + id);

		MaterialDTO material = null;
		material = materialService.getMaterial(id);

		System.out.println(material);

		model.addAttribute("keyMaterial", material);

		return "material/materialDetailView";
	}

}
