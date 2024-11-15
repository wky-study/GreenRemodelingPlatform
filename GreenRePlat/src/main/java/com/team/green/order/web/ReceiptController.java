package com.team.green.order.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.green.member.dto.MemberDTO;
import com.team.green.order.dto.PaymentDTO;
import com.team.green.order.service.OrderService;

@Controller
public class ReceiptController {
	
	@Autowired
	OrderService orderService;
	
	// 주문내역  
	@RequestMapping("/orderSummary")
	public String orderSummary(HttpSession session, PaymentDTO payment, Model model) {
		
		// 세션에서 memId 가져오기
		MemberDTO member = (MemberDTO)session.getAttribute("memInfo");
		String memId = member.getMemId();
		// DB에서 주문내역 가져오기
		List<PaymentDTO> paymentList = orderService.getOrderList(memId);
		System.out.println(paymentList);
		// model에 뿌리기
		model.addAttribute("keyPaymentList", paymentList);
		
		return "order/orderSummary";
	};
	
	// 영수증 창 띄우기 
	@RequestMapping("/receiptView")
	public String receiptView(String partnerOrderId , Model model) {
		System.out.println(partnerOrderId);
		
		PaymentDTO payment = orderService.getReceipt(partnerOrderId);
		
		System.out.println(payment);
		
		model.addAttribute("keyPayment", payment);
		
		return "order/receiptView";
	};
	
	// 주문내역 엑셀 다운로드

    Logger logger = LoggerFactory.getLogger(ReceiptController.class);
 
    @GetMapping("/downloadExcel")
    public ResponseEntity<InputStreamResource> downloadExcel(HttpServletResponse response, HttpSession session) throws IOException {
 
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("게시판글들");
            int rowNo = 0;
 
            CellStyle headStyle = workbook.createCellStyle();
            headStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIGHT_BLUE.getIndex());
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font font = workbook.createFont();
            font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            font.setFontHeightInPoints((short) 13);
            headStyle.setFont(font);
 
            Row headerRow = sheet.createRow(rowNo++);
            headerRow.createCell(0).setCellValue("결제 고유번호");
            headerRow.createCell(1).setCellValue("대표 주문번호");
            headerRow.createCell(2).setCellValue("주문번호");
            headerRow.createCell(3).setCellValue("상품명");
            headerRow.createCell(4).setCellValue("상품 가격");
            headerRow.createCell(5).setCellValue("전체 상품 가격");
            headerRow.createCell(6).setCellValue("결제일");
            for(int i=0; i<=6; i++){
            	// 컬럼명 스타일 추가 
                // headerRow.getCell(i).setCellStyle(headStyle);
                
            }
            
            MemberDTO member = (MemberDTO)session.getAttribute("memInfo");
            String memId = member.getMemId();
            
            // DB에서 리스트 불러올곳 
            List<PaymentDTO> list = orderService.getOrderList(memId);
            
            for (PaymentDTO payment : list) {
                Row row = sheet.createRow(rowNo++);
                row.createCell(0).setCellValue(payment.getTid());
                row.createCell(1).setCellValue(payment.getRepresentativeOrderId());
                row.createCell(2).setCellValue(payment.getPartnerOrderId());
                row.createCell(3).setCellValue(payment.getProdName());
                row.createCell(4).setCellValue(payment.getProdPrice());
                row.createCell(5).setCellValue(payment.getTotalPrice());
                row.createCell(6).setCellValue(payment.getPaymentDate());
            }
 
            sheet.setColumnWidth(0, 4000);
            sheet.setColumnWidth(1, 4000);
            sheet.setColumnWidth(2, 4000);
            sheet.setColumnWidth(3, 4000);
            sheet.setColumnWidth(4, 4000);
            sheet.setColumnWidth(5, 4000);
            sheet.setColumnWidth(6, 4000);
 
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
                    .header("Content-Disposition", "attachment;filename=orderlist.xlsx") //
                    .body(new InputStreamResource(res));
 
        }
    }	
	
}
