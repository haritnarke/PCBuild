package com.test.automation.PcBuild.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.automation.PcBuild.Config.ReadPropertiesFile;

public class TestBase extends ReadPropertiesFile {

	public static WebDriver driver;
	public FileOutputStream fileOut;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet1;
	public XSSFRow row;
	public XSSFCell col;
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	Date date = new Date();
	public String currentdate = dateFormat.format(date);

	public String excelpath1 = "C:\\Users\\madhav\\eclipse-workspace\\PcBuild\\src\\main\\java\\com\\test\\automation\\PcBuild\\DataFolder\\LowestPriceLists_"+currentdate+".xlsx";

	public String excelpath = "C:\\Users\\madhav\\eclipse-workspace\\PcBuild\\src\\main\\java\\com\\test\\automation\\PcBuild\\DataFolder\\PriceLists_"+currentdate+".xlsx";

	
	
	public void SelectBrowser(String browser, String url) throws IOException {

		if (browser.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", PropertiesValue("chromedriverpath"));
			driver = new ChromeDriver();
			initialise(browser, url);

		}

		else if (browser.equals("Firefox")) {

			System.setProperty("webdriver.gecko.driver", PropertiesValue("firefoxdriverpath"));

			driver = new FirefoxDriver();

			initialise(url);

		}

		else {

			System.out.println("Enterd browser isnt supported/n please try again with supported browser");

		}

	}

	public void initialise(String url) throws IOException {

		driver.get(url);

		// driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void initialise(String browser, String url) throws IOException {

		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// System.out.println("Browser ->"+browser+" ->"+driver.getTitle());

	}

	public String GetTitle() {

		return (driver.getCurrentUrl());
	}

	public void quitBrowser() {

		driver.close();
	}

	
	
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

		//System.out.println(d);
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
		
		try {
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

		

	
	
	public void CreateLowestPriceExcelFile(int i) {

		//System.out.println(d);
		File srcfile = new File(excelpath1);

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
		
		try {
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
	
	public void Createrow(int i)
	{
		
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

		XSSFRow row = sheet1.createRow(i);

		try {
			fileOut = new FileOutputStream(srcfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}

		
		
		try {
			workbook.write(fileOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found During Writing Data");
			e.printStackTrace();

		}
		
		try {
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	

	public void Createroww(int i)
	{
		
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

		// System.out.println("Sheet Already Exist");

		sheet1 = workbook.getSheet("Prices");

		XSSFRow row = sheet1.createRow(i);

		try {
			fileOut = new FileOutputStream(srcfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}

		
		
		try {
			workbook.write(fileOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found During Writing Data");
			e.printStackTrace();

		}
		
		try {
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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

		
		try {
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void WriteDataInExcel(int i,String excelpath) {

		// Load the excel file
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

		
		try {
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
	public void WriteDataInExcel(String Company,String Product,String Price,String Date,int col,int row,String excelpath) throws IOException {

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
		sheet1.getRow(row).createCell(col).setCellValue(PropertiesValue(Company));
		sheet1.getRow(row).createCell(++col).setCellValue(PropertiesValue(Product));
		int NumericPrice = Integer.parseInt(Price);
		sheet1.getRow(row).createCell(++col).setCellValue(NumericPrice);
		sheet1.getRow(row).createCell(++col).setCellValue(Date);

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


	
	
	public void WriteDataInExcel(String Company,String Product,int Price,String Date,int row,String excelpath1) throws IOException {

		// Load the excel file
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

		// System.out.println("Sheet Already Exist");
		//int i=0;
		
		XSSFSheet sheet2 = workbook.getSheet("Prices");
		//this.sheet1 = sheet1;
		
CellStyle style = workbook.createCellStyle();
		
		style.setBorderRight(BorderStyle.THIN);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderLeft(BorderStyle.THIN);
	    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderTop(BorderStyle.THIN);
	    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderBottom(BorderStyle.THIN);
	    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		
		
		XSSFRow row1 = sheet2.createRow(row);
		
		
		sheet2.getRow(0).getCell(0).setCellStyle(style);
		sheet2.getRow(0).getCell(1).setCellStyle(style);
		sheet2.getRow(0).getCell(2).setCellStyle(style);
		sheet2.getRow(0).getCell(3).setCellStyle(style);
		
		
		sheet2.getRow(row).createCell(0).setCellValue(Company);
		sheet2.getRow(row).getCell(0).setCellStyle(style);
		
		sheet2.getRow(row).createCell(1).setCellValue(Product);
		sheet2.getRow(row).getCell(1).setCellStyle(style);
		
		sheet2.getRow(row).createCell(2).setCellValue(Price);
		sheet2.getRow(row).getCell(2).setCellStyle(style);
		
		sheet2.getRow(row).createCell(3).setCellValue(Date);
		sheet2.getRow(row).getCell(3).setCellStyle(style);
		
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

	public String formatprice(String price) {
		
		 String formatedprice = price.replaceAll(".00","");
		 return formatedprice;
	}
	
	
	}
