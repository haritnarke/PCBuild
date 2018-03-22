package com.test.automation.PcBuild.Logical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.test.automation.PcBuild.TestBase.TestBase;

public class TotalCostingCalculationLogic extends TestBase{

	
	public void totalcost() throws IOException {
		
		//Opening the file
		File srcfile = new File(excelpath1);
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

		
		
		XSSFSheet sheet3 = workbook.getSheet("Prices");
		row=sheet3.createRow(8);
		
		CellStyle style = workbook.createCellStyle();
		
		style.setBorderRight(BorderStyle.THIN);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderLeft(BorderStyle.THIN);
	    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderTop(BorderStyle.THIN);
	    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderBottom(BorderStyle.THIN);
	    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		
	    
	    CellStyle style2 = workbook.createCellStyle();
		
        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 20);
        font.setFontName("IMPACT");
        font.setItalic(true);
        font.setColor(HSSFColor.CORNFLOWER_BLUE.index);
        style2.setFont(font);
        sheet3.getRow(8).createCell(1).setCellStyle(style);
        sheet3.getRow(8).getCell(1).setCellValue("TOTAL     :");
        sheet3.getRow(8).getCell(1).setCellStyle(style2);
        
        
        
        
		
		int totalRow = sheet3.getLastRowNum() + 1;
		int totalColumn = sheet3.getRow(0).getLastCellNum();
		
		System.out.println("TotalRows  :"+totalRow);
		
			
		sheet3.getRow(8).createCell(2).setCellStyle(style);;
		
		sheet3.getRow(8).getCell(2).setCellType(CellType.FORMULA);
		sheet3.getRow(8).getCell(2).setCellFormula("SUM(C2:C7)");
		sheet3.getRow(8).getCell(2).setCellStyle(style2);
        
		//sheet3.getRow(8).getCell(0).setCellStyle(style);
		//sheet3.getRow(8).getCell(1).setCellStyle(style);
		//sheet3.getRow(8).getCell(2).setCellStyle(style);
		//sheet3.getRow(8).getCell(3).setCellStyle(style);
		
	
		
		fis.close();
		try {
			fileOut = new FileOutputStream(srcfile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			workbook.write(fileOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found During Writing Data");
			e.printStackTrace();

		}

		
		fileOut.close();

		
	}
}
