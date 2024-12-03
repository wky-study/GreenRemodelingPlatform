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
	 				atchFileName = "http://localhost/displayImage?fileName=" + attachList.get(0).getAtchFileName();
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

		
		return "redirect:/productView";
	}
	
	// ��ǰ ����
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
	
	// ��ǰ ��� ���
    Logger logger = LoggerFactory.getLogger(ReceiptController.class);
 
    @GetMapping("/downloadProdExcel")
    public ResponseEntity<InputStreamResource> downloadProdExcel(HttpServletResponse response, HttpSession session) throws IOException {
 
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("��ǰ ��� ���");
            int rowNo = 0;
 
            CellStyle headStyle = workbook.createCellStyle();
            headStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIGHT_BLUE.getIndex());
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font font = workbook.createFont();
            font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            font.setFontHeightInPoints((short) 13);
            headStyle.setFont(font);
 
            Row headerRow = sheet.createRow(rowNo++);
            headerRow.createCell(0).setCellValue("��ü��");
            headerRow.createCell(1).setCellValue("�𵨸�");
            headerRow.createCell(2).setCellValue("������");
            headerRow.createCell(3).setCellValue("������ȿ��");
            headerRow.createCell(4).setCellValue("��ǰ�̸�");
            headerRow.createCell(5).setCellValue("����");
            headerRow.createCell(6).setCellValue("��ǰŸ��");
            headerRow.createCell(7).setCellValue("��ǥ�̹����ּ�");
            for(int i=0; i<=7; i++){
            	// �÷��� ��Ÿ�� �߰� 
                // headerRow.getCell(i).setCellStyle(headStyle);
                
            }
            
            
            Row row = sheet.createRow(rowNo++);
            row.createCell(0).setCellValue("�������� �ֽ�ȸ��");
            row.createCell(1).setCellValue("CRP-LHTR0620FGW");
            row.createCell(2).setCellValue("��������(��)");
            row.createCell(3).setCellValue("1");
            row.createCell(4).setCellValue("���� ��ǰ���� CRI-HC0620H ��ü�� CRP-LHTR0610FGW/M ȣȯ 260J");
            row.createCell(5).setCellValue("100000");
            row.createCell(6).setCellValue("������");
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
                    	System.out.println("�ӽ� ���� ���� �Ϸ�");
                    }
                }
            };
 
            return ResponseEntity.ok() //
                    .contentLength(tmpFile.length()) //
                    .contentType(MediaType.APPLICATION_OCTET_STREAM) //
                    .header("Content-Disposition", 
                            "attachment; filename*=UTF-8''" + URLEncoder.encode("��ǰ���_���.xlsx", "UTF-8"))
                    .body(new InputStreamResource(res));
 
        }
    }
    
    @RequestMapping("/ocrTest")
	public String ocrTest() {
    	

		
		return "product/ocrTest";
	}
    
    
	
}
