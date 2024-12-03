package com.team.green.product.web;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team.green.attach.dto.AttachDTO;
import com.team.green.attach.service.AttachService;
import com.team.green.common.vo.FileUploadVO;
import com.team.green.common.vo.SearchVO;
import com.team.green.member.dto.MemberDTO;
import com.team.green.order.dto.PaymentDTO;
import com.team.green.order.web.ReceiptController;
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
	 				atchFileName = "http://localhost/displayImage?fileName=" + attachList.get(0).getAtchFileName();
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

		
		return "redirect:/productView";
	}
	
	// 제품 삭제
	@PostMapping("/prodDeleteDo")
	public String prodDeleteDo(int no) {
		System.out.println(no);
		productService.deleteProd(no);
		
		return "redirect:/productView";
		
	}
	
	
	@PostMapping("/addExcel")
	 public String readExcel(@RequestParam("file") MultipartFile file, Model model)
		      throws IOException { 

			XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		    XSSFSheet worksheet = workbook.getSheetAt(0);
		    
		    System.out.println(worksheet.getPhysicalNumberOfRows());
		    
		    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
		        ProductDTO prod = new ProductDTO();
		        
		        DataFormatter formatter = new DataFormatter();		        
		        XSSFRow row = worksheet.getRow(i);
		        	    	
		        String prodCompany = formatter.formatCellValue(row.getCell(0));
		        String prodModel = formatter.formatCellValue(row.getCell(1));
		        String prodManufacturer = formatter.formatCellValue(row.getCell(2));
		        String prodEfficiency = formatter.formatCellValue(row.getCell(3));
		        String prodName = formatter.formatCellValue(row.getCell(4));
		        String prodPrice = formatter.formatCellValue(row.getCell(5));
		        String prodType = formatter.formatCellValue(row.getCell(6));
		        String prodImageSrc = formatter.formatCellValue(row.getCell(7));
		        
		        prod.setProdCompany(prodCompany);
		        prod.setProdModel(prodModel);
		        prod.setProdManufacturer(prodManufacturer);
		        prod.setProdEfficiency(prodEfficiency);
		        prod.setProdName(prodName);
		        prod.setProdPrice(prodPrice);
		        prod.setProdType(prodType);
		        prod.setProdImageSrc(prodImageSrc);
     
		        productService.writeProduct(prod);
		    } 
		    return "redirect:/productView"; 

		  }
	
	// 제품 등록 양식
    Logger logger = LoggerFactory.getLogger(ReceiptController.class);
 
    @GetMapping("/downloadProdExcel")
    public ResponseEntity<InputStreamResource> downloadProdExcel(HttpServletResponse response, HttpSession session) throws IOException {
 
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("제품 등록 양식");
            int rowNo = 0;
 
            CellStyle headStyle = workbook.createCellStyle();
            headStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIGHT_BLUE.getIndex());
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font font = workbook.createFont();
            font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            font.setFontHeightInPoints((short) 13);
            headStyle.setFont(font);
 
            Row headerRow = sheet.createRow(rowNo++);
            headerRow.createCell(0).setCellValue("업체명");
            headerRow.createCell(1).setCellValue("모델명");
            headerRow.createCell(2).setCellValue("제조원");
            headerRow.createCell(3).setCellValue("에너지효율");
            headerRow.createCell(4).setCellValue("제품이름");
            headerRow.createCell(5).setCellValue("가격");
            headerRow.createCell(6).setCellValue("제품타입");
            headerRow.createCell(7).setCellValue("대표이미지주소");
            for(int i=0; i<=7; i++){
            	// 컬럼명 스타일 추가 
                // headerRow.getCell(i).setCellStyle(headStyle);
                
            }
            
            
            Row row = sheet.createRow(rowNo++);
            row.createCell(0).setCellValue("쿠쿠전자 주식회사");
            row.createCell(1).setCellValue("CRP-LHTR0620FGW");
            row.createCell(2).setCellValue("쿠쿠전자(주)");
            row.createCell(3).setCellValue("1");
            row.createCell(4).setCellValue("쿠쿠 정품내솥 CRI-HC0620H 교체용 CRP-LHTR0610FGW/M 호환 260J");
            row.createCell(5).setCellValue("100000");
            row.createCell(6).setCellValue("전기밥솥");
            row.createCell(7).setCellValue("https://shop2.daumcdn.net/thumb/R160x160/?fname=http%3A%2F%2Fshop2.daumcdn.net%2Fshophow%2Fp%2FD5122744359.jpg%3Fut%3D20231116171425");
 
            sheet.setColumnWidth(0, 4000);
            sheet.setColumnWidth(1, 4000);
            sheet.setColumnWidth(2, 4000);
            sheet.setColumnWidth(3, 4000);
            sheet.setColumnWidth(4, 4000);
            sheet.setColumnWidth(5, 4000);
            sheet.setColumnWidth(6, 4000);
            sheet.setColumnWidth(7, 4000);
 
            File tmpFile = File.createTempFile("TMP~", ".xlsx");
            try (OutputStream fos = new FileOutputStream(tmpFile);) {
                workbook.write(fos);
            }
            InputStream res = new FileInputStream(tmpFile) {
                @Override
                public void close() throws IOException {
                    super.close();
                    if (tmpFile.delete()) {
                    	System.out.println("임시 파일 삭제 완료");
                    }
                }
            };
 
            return ResponseEntity.ok() //
                    .contentLength(tmpFile.length()) //
                    .contentType(MediaType.APPLICATION_OCTET_STREAM) //
                    .header("Content-Disposition", 
                            "attachment; filename*=UTF-8''" + URLEncoder.encode("제품등록_양식.xlsx", "UTF-8"))
                    .body(new InputStreamResource(res));
 
        }
    }
    
    @RequestMapping("/ocrTest")
	public String ocrTest() {
    	

		
		return "product/ocrTest";
	}
    
    
	
}
