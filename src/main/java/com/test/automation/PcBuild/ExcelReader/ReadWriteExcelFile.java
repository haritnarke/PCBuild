package com.test.automation.PcBuild.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.test.automation.PcBuild.Config.ReadPropertiesFile;

public class ReadWriteExcelFile extends ReadPropertiesFile{
	
	Date date = new Date();
	public FileOutputStream fileOut;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet1;
	public XSSFRow row;
	public XSSFCell col;
	public String d=date.toString();
	
	public String excelpath = "C:\\Users\\madhav\\eclipse-workspace\\PcBuild\\src\\main\\java\\com\\test\\automation\\PcBuild\\DataFolder\\PriceLists1.xlsx";
	
	public void ReadWriteExcelFile(String excelpath) {
		// TODO Auto-generated constructor stub
		File src = new File(excelpath);
		try {
			fis = new FileInputStream(src);
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
	}

	// Creating an excelfile and an empty row
	public void CreateExcelFile(int i) {

		System.out.println(d);
		File srcfile = new File(excelpath);

		try {
			fileOut = new FileOutputStream(srcfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}

		XSSFWorkbook workbook1 = new XSSFWorkbook();
		XSSFSheet sheet = workbook1.createSheet("Prices");
		XSSFRow row = sheet.createRow(i);

		try {
			workbook1.write(fileOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found During Writing Data");
			e.printStackTrace();

		}

	}

		
	
	
	
	public void WriteDataInExcel(int i) {

		// Load the excel file
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

		// System.out.println("Sheet Already Exist");

		sheet1 = workbook.getSheet("Prices");
		sheet1.getRow(0).createCell(i).setCellValue("Company");
		sheet1.getRow(0).createCell(++i).setCellValue("Product");
		sheet1.getRow(0).createCell(++i).setCellValue("Price");
		sheet1.getRow(0).createCell(++i).setCellValue("Date");

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

	}

	
	
	public void WriteDataInExcel(String Company,String Product,String Price,String Date,int col) throws IOException {

		// Load the excel file
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

		// System.out.println("Sheet Already Exist");
		//int i=0;
		sheet1 = workbook.getSheet("Prices");
		sheet1.getRow(1).createCell(col).setCellValue(PropertiesValue(Company));
		sheet1.getRow(1).createCell(++col).setCellValue(PropertiesValue(Product));
		sheet1.getRow(1).createCell(++col).setCellValue(PropertiesValue(Price));
		sheet1.getRow(1).createCell(++col).setCellValue(PropertiesValue(Date));

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

	}


	
	
	
	public String getdata(String sheetname, int rownum, int column) {

		
		sheet1 = workbook.getSheet(sheetname);

		if (rownum > getrow(sheetname) && column > getcol(sheetname)) {
			System.out.println("Row number or colum number not present in the given excel sheet");
		}
		String s1 = sheet1.getRow(rownum).getCell(column).getStringCellValue();
		return s1;

	}

	public int getrow(String sheetname) {
		sheet1 = workbook.getSheet(sheetname);
		int totalRow = sheet1.getLastRowNum() + 1;
		return totalRow;
	}

	public int getcol(String sheetname) {
		sheet1 = workbook.getSheet(sheetname);
		int totalColumn = sheet1.getRow(0).getLastCellNum();
		return totalColumn;
	}

}
