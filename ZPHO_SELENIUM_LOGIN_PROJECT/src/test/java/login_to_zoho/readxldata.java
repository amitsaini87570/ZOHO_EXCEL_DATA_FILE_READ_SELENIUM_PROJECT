package login_to_zoho;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class readxldata {
	@DataProvider(name = "testdata")
	public String[][]getData(Method m)throws EncryptedDocumentException,IOException{
		
		String excelSheetname = m.getName();
		File f = new File("C:\\Users\\amits\\eclipse-workspace\\ZPHO_SELENIUM_LOGIN_PROJECT\\src\\test\\resources\\testdata\\login_testdata_zoho.xlsx");

		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(excelSheetname);
	
		int totalrows = sheet.getLastRowNum();
		System.out.println(totalrows);
		Row rowcell = sheet.getRow(0);
		int totalcolums =rowcell.getLastCellNum();
		System.out.println(totalcolums);
		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalrows][totalcolums];
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcolums;j++) {
	testData[i-1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
	System.out.println(testData[i-1][j]);
			}}
		return testData;
		
	}
}
