package com.team.green.product.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.team.green.attach.dto.AttachDTO;
import com.team.green.attach.service.AttachService;
import com.team.green.common.vo.FileUploadVO;
import com.team.green.common.vo.SearchVO;
import com.team.green.product.dto.ProductDTO;
import com.team.green.product.service.ProductService;

@Controller
public class ProductController {

	@Value("#{util['file.attach.path']}")
	String attachPath;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	AttachService attachService;
	
	@Autowired
	FileUploadVO fileUpload;	
	
    @RequestMapping("/productView")
	public String productView(Model model, SearchVO search) {
    	
		int productCount = productService.getProductCount(search);
		// DB�� ���� ������ ��ü �Խñ��� ���� search�� �ʵ庯���� �־���
		search.setProdCount(productCount);
		search.setting();
		
		List<ProductDTO> productList = productService.getProductList(search);
		
		System.out.println(search);
		System.out.println(productList);
		
		model.addAttribute("keyProduct",productList);
		
		model.addAttribute("keySearch", search);
		
		return "product/productView";
	}
    
	// ��ǰ �� �� ������
	@RequestMapping("/productDetailView")
	public String reviewDetailView(Model model, int no) {
		
		System.out.println("Ŭ���� �Խñ� ��ȣ" + no);
		
		ProductDTO product = null;
		product = productService.getProduct(no);
		
		System.out.println(product);
		
		model.addAttribute("keyProduct", product);
		
		// �̹��� ������ ��� ��������
		List<AttachDTO> atch = attachService.getProdAttachList(no);
		model.addAttribute("keyAtchList", atch);
		
		System.out.println(atch);
		
		return "product/productDetailView";
	}
	
	// ��ǰ �� ��� ������
	@RequestMapping("/productWriteView")
	public String productWriteView(HttpSession session) {
		
		System.out.println(session.getAttribute("memInfo"));
		
//		if(session.getAttribute("memInfo") == null) {
//			return "redirect:/loginView";
//		}
		
		return "product/productWriteView";
	}
	
	// ��ǰ �� ��� Ŭ��
	@PostMapping("/productWriteDo")
	public String productWriteDo(ProductDTO product, MultipartFile[] imgFile) {

	    System.out.println(product);

	 	int prodNo = productService.getProdNo();
	 	
	 	String atchFileName = "";
	 	
	 	// ÷�ε� ������ ������ �� ������ ���ÿ� �����ϰ� DB�� ����� ������ ������ ������
	 	// ÷�������� ���� �� ����Ǿ���
	 	if(imgFile != null && imgFile.length > 0 && !imgFile[0].isEmpty()) {
	 		System.out.println("���� ����: " + imgFile.length);
	 		
	 		
	 		try {
	 			List<AttachDTO> attachList = fileUpload.saveFiles(imgFile);
	 			
	 			System.out.println(attachList);
	 			
	 			if(!attachList.isEmpty()) {
	 				for(AttachDTO attach : attachList) {
	 					attach.setProdNo(prodNo);
	 					attachService.insertProdAttach(attach);
	 				}
	 				// ù��° �̹����� ��ǥ�̹����� ���  
	 				atchFileName = "http://localhost:9090/green/displayImage?fileName=" + attachList.get(0).getAtchFileName();
	 			}
	 		} catch(IOException e) {
	 			e.printStackTrace();
	 			System.out.println("���ε�ȵ�");
	 			return "product/productView";
	 		}
	 	}
	 	
	 	// img src ���
	 	System.out.println(atchFileName);
	 	product.setProdImageSrc(atchFileName);

	    // �������� ���
	    productService.writeProduct(product); // �������� ��� ���� ȣ��

		
		return "redirect:productView";
	}
	
	
	
	
	
	
	
	
}
