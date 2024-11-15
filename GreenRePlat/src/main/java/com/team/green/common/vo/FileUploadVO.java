package com.team.green.common.vo;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.team.green.attach.dto.AttachDTO;

@Component
public class FileUploadVO {

    @Value("#{util['file.attach.path']}")
    String attachPath;
    
    // ���� ���� ���� �޼���
    public AttachDTO saveFile(MultipartFile noFile) throws IOException {
        String fileName = UUID.randomUUID().toString();
        File uploadFolder = new File(attachPath);
        uploadFolder.mkdir();
        String atchPath = attachPath + File.separatorChar + fileName;
        
        noFile.transferTo(new File(atchPath));
        
        AttachDTO result = new AttachDTO();
        result.setAtchFileName(fileName);
        result.setAtchOriginalName(noFile.getOriginalFilename());
        result.setAtchFileSize(noFile.getSize());
        result.setAtchFancySize(transferToFancy(noFile.getSize()));
        result.setAtchContentType(noFile.getContentType());
        result.setAtchPath(atchPath);
        
        return result;
    }
    
    // ���� ���� ���� �޼��� �߰�
    public List<AttachDTO> saveFiles(MultipartFile[] files) throws IOException {
        List<AttachDTO> attachList = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                AttachDTO attach = saveFile(file); // �� ������ ���������� ����
                attachList.add(attach); // AttachDTO ��ü�� ����Ʈ�� �߰�
            }
        }
        return attachList; // ��� ������ ������ ����Ʈ�� ��ȯ
    }

    // ���� ũ�⸦ ����� �б� ���� �������� ��ȯ
    public String transferToFancy(long size) {
        String[] nB = { "Byte", "KB", "MB", "GB", "TB" };
        if (size == 0) {
            return "0 Byte";
        }
        int idx = (int) (Math.log(size) / Math.log(1024));
        DecimalFormat df = new DecimalFormat("#,###.##");
        double r = size / Math.pow(1024, idx);
        return df.format(r) + " " + nB[idx];
    }
    
    // �̹��� ���� �޼���
    public AttachDTO saveImg(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString();
        String atchPath = attachPath + File.separatorChar + fileName;
        
        file.transferTo(new File(atchPath));
        
        AttachDTO result = new AttachDTO();
        result.setAtchPath(fileName);
        
        return result;
    }
}
