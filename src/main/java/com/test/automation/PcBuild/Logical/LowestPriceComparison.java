package com.test.automation.PcBuild.Logical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.test.automation.PcBuild.TestBase.TestBase;

public class LowestPriceComparison extends TestBase {

	public void lowestprice() throws IOException {

		File srcfile = new File(excelpath);
		try {
			fis = new FileInputStream(srcfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet1 = workbook.getSheet("Prices");
		
		
        
		int totalRow = sheet1.getLastRowNum() + 1;
		int totalColumn = sheet1.getRow(0).getLastCellNum();

		for (int i = 1; i < totalRow; i++) {

			int j = 2;

			int a = (int) sheet1.getRow(i).getCell(j).getNumericCellValue();
			int b = (int) sheet1.getRow(i).getCell(j + 4).getNumericCellValue();
			int c = (int) sheet1.getRow(i).getCell(j + 8).getNumericCellValue();

			if (a < b && a < c) {

				String s1 = sheet1.getRow(i).getCell(0).getStringCellValue();
				String s2 = sheet1.getRow(i).getCell(1).getStringCellValue();
				String s3 = sheet1.getRow(i).getCell(3).getStringCellValue();
				WriteDataInExcel(s1, s2, a, s3, i, excelpath1);

			} else if (b < c && b < a) {

				String s1 = sheet1.getRow(i).getCell(4).getStringCellValue();
				String s2 = sheet1.getRow(i).getCell(5).getStringCellValue();
				String s3 = sheet1.getRow(i).getCell(7).getStringCellValue();
				WriteDataInExcel(s1, s2, b, s3, i, excelpath1);
			} else {

				String s1 = sheet1.getRow(i).getCell(8).getStringCellValue();
				String s2 = sheet1.getRow(i).getCell(9).getStringCellValue();
				String s3 = sheet1.getRow(i).getCell(11).getStringCellValue();
				WriteDataInExcel(s1, s2, c, s3, i, excelpath1);
				
			}

		}
		
		
	}

}
