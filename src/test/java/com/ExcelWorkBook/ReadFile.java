package com.ExcelWorkBook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;
import org.testng.annotations.Test;

public class ReadFile {

	@Test
	private void readFile() throws XmlException {

		String file = ".\\ExcelData\\Book9.xlsx";
		XSSFWorkbook wb = null;

		try {
			FileInputStream fis = new FileInputStream(file);
			 wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = sheet.getRow(5);
			XSSFCell cell = row.getCell(7);
			CellType cellType = cell.getCellType();

			if (cellType.equals(CellType.STRING)) {

				String stringCellValue = cell.getStringCellValue();
				System.out.println(stringCellValue);

			}
			;
			if (cellType.equals(CellType.NUMERIC)) {

				double numericCellValue = cell.getNumericCellValue();
				int num = (int) numericCellValue;

				System.out.println(num);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NullPointerException ne) {
			System.out.println(ne.getLocalizedMessage());
			
		} finally {
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}

	
}
