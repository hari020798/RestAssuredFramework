package com.ExcelWorkBook;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadAllFileDynamically {
/* 
 * String file
 * workbook
 * sheet "index or name"
 * PhsicalNumberofrow
 * ForLoop i
 * getRow
 * getRow of lastCellNumber
 * forLoop j
 * getCell
 * DataFormatter
 * SYso Cell
 *-----OtherOption
 *getCell type
 *if cell type.equals String
 *if cell type equals CellType.Numeric
 *Sysout
 * 
 * */
	@Test
	private void readAll() throws IOException {

		String xcelFile = ".\\ExcelData\\ExcelWB.xlsx";
		XSSFWorkbook wb = new XSSFWorkbook(xcelFile);
		XSSFSheet sheet = wb.getSheetAt(0);
		int PNOR = sheet.getPhysicalNumberOfRows();
		for (int i = 1; i < PNOR; i++) {

			XSSFRow row = sheet.getRow(i);
			short lCM = sheet.getRow(0).getLastCellNum();
			for (int j = 0; j < lCM; j++) {

				XSSFCell cell = row.getCell(j);
				//String SCV = cell.getStringCellValue();
				DataFormatter  dF = new DataFormatter();
				String formatCellValue = dF.formatCellValue(cell);
				System.out.println(formatCellValue);
			}

		}
		wb.close();

	}
}
