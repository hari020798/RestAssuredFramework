package com.ExcelWorkBook;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadFile1 {

	/*
	 * ReadFille ReadWB and Sheet Readrow and cell(Column)
	 */

	@Test
	private void ReadFile() throws IOException {

		String fileLocation = ".\\ExcelData\\ExcelWB.xlsx";

		XSSFWorkbook Wb = new XSSFWorkbook(fileLocation);

		XSSFSheet sheet = Wb.getSheetAt(0);

		for (int i = 1; i <= 3; i++) {
			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < 2; j++) {

				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				// String value = cell.getStringCellValue();
				if (cellType.equals(CellType.STRING)) {
					String scv = cell.getStringCellValue();
					System.out.println(scv);

				}

				else if (cellType.equals(CellType.NUMERIC)) {

					double numericCellValue = cell.getNumericCellValue();
					int value = (int) numericCellValue;

					System.out.println(value);

				}
			}
		}
		Wb.close();

	}

}
