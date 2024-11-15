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
		// DB로 부터 가져온 전체 게시글의 수를 search의 필드변수에 넣어줌
		search.setProdCount(productCount);
		search.setting();
		
		List<ProductDTO> productList = productService.getProductList(search);
		
		System.out.println(search);
		System.out.println(productList);
		
		model.addAttribute("keyProduct",productList);
		
		model.addAttribute("keySearch", search);
		
		return "product/productView";
	}
    
	// 제품 글 상세 페이지
	@RequestMapping("/productDetailView")
	public String reviewDetailView(Model model, int no) {
		
		System.out.println("클릭한 게시글 번호" + no);
		
		ProductDTO product = null;
		product = productService.getProduct(no);
		
		System.out.println(product);
		
		model.addAttribute("keyProduct", product);
		
		// 이미지 여러개 경로 가져오기
		List<AttachDTO> atch = attachService.getProdAttachList(no);
		model.addAttribute("keyAtchList", atch);
		
		System.out.println(atch);
		
		return "product/productDetailView";
	}
	
	// 제품 글 등록 페이지
	@RequestMapping("/productWriteView")
	public String productWriteView(HttpSession session) {
		
		System.out.println(session.getAttribute("memInfo"));
		
//		if(session.getAttribute("memInfo") == null) {
//			return "redirect:/loginView";
//		}
		
		return "product/productWriteView";
	}
	
	// 제품 글 등록 클릭
	@PostMapping("/productWriteDo")
	public String productWriteDo(ProductDTO product, MultipartFile[] imgFile) {

	    System.out.println(product);

	 	int prodNo = productService.getProdNo();
	 	
	 	String atchFileName = "";
	 	
	 	// 첨부된 파일이 존재할 시 파일을 로컬에 저장하고 DB에 저장된 파일의 정보를 전달함
	 	// 첨부파일이 있을 때 실행되야함
	 	if(imgFile != null && imgFile.length > 0 && !imgFile[0].isEmpty()) {
	 		System.out.println("파일 개수: " + imgFile.length);
	 		
	 		
	 		try {
	 			List<AttachDTO> attachList = fileUpload.saveFiles(imgFile);
	 			
	 			System.out.println(attachList);
	 			
	 			if(!attachList.isEmpty()) {
	 				for(AttachDTO attach : attachList) {
	 					attach.setProdNo(prodNo);
	 					attachService.insertProdAttach(attach);
	 				}
	 				// 첫번째 이미지를 대표이미지로 등록  
	 				atchFileName = "http://localhost:9090/green/displayImage?fileName=" + attachList.get(0).getAtchFileName();
	 			}
	 		} catch(IOException e) {
	 			e.printStackTrace();
	 			System.out.println("업로드안됨");
	 			return "product/productView";
	 		}
	 	}
	 	
	 	// img src 담기
	 	System.out.println(atchFileName);
	 	product.setProdImageSrc(atchFileName);

	    // 공지사항 등록
	    productService.writeProduct(product); // 공지사항 등록 서비스 호출

		
		return "redirect:productView";
	}
	
	
	
	
	
	
	
	
}
