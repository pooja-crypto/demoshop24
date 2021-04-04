package com.demoshop24.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.demoshop24.base.BasePage;

public class TestUtil extends BasePage {

	public TestUtil(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	public static Object[][] getTestData(String FilePath, String SheetName) throws Exception {
		FileInputStream ExcelFile = new FileInputStream(FilePath);

		// Access the required test data sheet

		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		Object[][] data = new Object[ExcelWSheet.getLastRowNum()][ExcelWSheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < ExcelWSheet.getLastRowNum(); i++) {
			for (int k = 0; k < ExcelWSheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = ExcelWSheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;

	}

}