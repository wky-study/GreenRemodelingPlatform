package com.team.green.attach.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team.green.attach.dto.AttachDTO;
import com.team.green.attach.service.AttachService;
import com.team.green.common.vo.FileUploadVO;



@Controller
public class AttachController {

	@Value("#{util['file.attach.path']}")
	String attachPath;
	
	@Autowired
	AttachService attachService;
	
	@Autowired
	FileUploadVO fileUpload;
	
	
	// fileDownload?fileName=qeqwe26-11weqe1-123qewqe-eqwe124
	// ���� �ٿ�ε�
	@RequestMapping("/filedownload")
	public void fileDownload(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		// ���ÿ� ����� �����̸��� ����÷�� ��� ���� ���� �̸� �޾ƿ�
		String fileName = request.getParameter("fileName");
		String fileOriName = request.getParameter("fileOriName");
		
		// ���ÿ� ����� ������ File ��ü�� ��Ī
		File downloadFile = new File(attachPath + File.separatorChar + fileName);
				
		// �ش� ������ �����͸� �о byte �迭�� ����
		byte[] fileByte = FileUtils.readFileToByteArray(downloadFile);
		
		// ���� �����ͷ� �Ѱ��� �غ�
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		
		// ���� ���ϸ����� �ٿ�޾������� ��
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileOriName, "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// ���� �����ͷ� ���� ����
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
	}
	

	
	// ���� ���ε�
	@ResponseBody
	@PostMapping("/uploadImg")
	public String uploadImg(MultipartFile file, HttpSession session) {
		
		String uuid = "";
		
		try {
			AttachDTO uploadImg = fileUpload.saveFile(file);
			System.out.println(uploadImg);
			
			uuid = uploadImg.getAtchFileName();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Attach��Ʈ�ѷ����� uuid reviewWriteView�� ���� : " + uuid);
		
		return uuid;
		
	}	
	
	// ����� �̹��� ������ �о ���� �����ͷ� �Ѱ��ֱ�
	@RequestMapping("/displayImage")
	public ResponseEntity<byte[]> displayImage(String fileName) {
		
		// ��û�� �Ѿ�� fileName�� �̿��Ͽ� ���� ����� �̹��� ������ �о����
		
		// �̹��� ������ Ǯ��� ���� (C:\\upload\\7fe29986-7fa8-4ff8-80dc-6eda1cd44150)
		String imgPath = attachPath + File.separatorChar + fileName;
		
		// ResponseEntity �� ��� (header) ������ ���� HttpHeaders ��ü ����
		HttpHeaders headers = new HttpHeaders();
		
		// headers�� ������ Ÿ�� ���� (�̹���)
		headers.setContentType(MediaType.IMAGE_PNG);
		
		ResponseEntity<byte[]> result = null;
		
		try(FileInputStream fis = new FileInputStream(imgPath);) {
			
			// fis �κ��� �̹��� ���� �о byte �迭�� ����
			byte[] data = IOUtils.toByteArray(fis);
			
			// ���信 ���� ResponseEntity ��ü ���� (HttpStatus�� �����ڵ�)
			result = new ResponseEntity<byte[]>(data, headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			// ���� �߻��� ������ ���õ� �����ڵ带 ���� ResponseEntity ��ü ����
			result = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		
		return result;
		
	}
	
	
	
}
