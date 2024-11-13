package com.team.green.common.xssf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/*
 * 	https://poi.apache.org/apidocs/dev/org/apache/poi/xssf/usermodel/XSSFWorkbook.html
 * 	https://poi.apache.org/apidocs/dev/org/apache/poi/ss/usermodel/WorkbookFactory.html
 * 	참고하면 될듯
 */


public class ExcelFileIO {
	
	private String filePath;
	private File file;
	private Workbook workbook;

	public ExcelFileIO(String filePath) throws EncryptedDocumentException, FileNotFoundException, IOException {
		this.filePath = filePath;
		this.file = new File(filePath);
		this.workbook = WorkbookFactory.create(new FileInputStream(filePath));
		Sheet sheet = workbook.getSheet("sheetName");
	}
	
}
