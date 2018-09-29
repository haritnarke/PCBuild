package com.test.automation.PcBuild;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.automation.PcBuild.ExcelReader.ReadWriteExcelFile;
import com.test.automation.PcBuild.Logical.LowestPriceComparison;
import com.test.automation.PcBuild.TestBase.TestBase;
import com.test.automation.PcBuild.WebPages.amazon;
import com.test.automation.PcBuild.WebPages.mdcomputers;
import com.test.automation.PcBuild.WebPages.primebgb;
//import com.test.automation.PcBuild.Config.ReadPropertiesFile;
import com.test.automation.PcBuild.WebPages.theitdepot;

public class TC001_Get_Price_Details extends TestBase {

	ReadWriteExcelFile excel;
	LowestPriceComparison lowestpricecompare;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat FiledateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_ss");

	Date date = new Date();
	public String currentdate = dateFormat.format(date);
	public String Filecurrentdate = "_"+FiledateFormat.format(date);

	

	@Parameters({ "browser", "url" })
	@BeforeTest
	void setup(String browser, String url) throws IOException {

		SelectBrowser(browser, url);
	}

	@Test(enabled=true,groups="Functional")
	void Get_Computer_Parts_Prices() throws IOException, InvalidFormatException {

		if (GetTitle().contains("theitdepot")) {

			
			// Driver Initialisation
			theitdepot TheItDepot = new theitdepot(driver);
			CreateExcelFile(0);
			WriteDataInExcel(0);
			
			// Get the Cpu Price
			TheItDepot.GenericFunctionGetPrice(PropertiesValue("theitdepot_processor"));
			captureScreenShot("theitdepot_processor"+Filecurrentdate); 
			System.out.println("theitdepot_processor"+Filecurrentdate);
			Createrow(1);
			WriteDataInExcel("company1", "theitdepot_processor", TheItDepot.prices(), currentdate, 0, 1,excelpath);
			System.out.println("Cpu Price is  :" + TheItDepot.prices());
			TheItDepot.mainpage();

			// Get the MotherBoard Price
			TheItDepot.GenericFunctionGetPrice(PropertiesValue("theitdepot_motheboard"));
			captureScreenShot("theitdepot_motheboard"+Filecurrentdate); 
			Createrow(2);
			WriteDataInExcel("company1", "theitdepot_motheboard", TheItDepot.prices(), currentdate, 0, 2,excelpath);
			System.out.println("Motherboard Price is  :" + TheItDepot.prices());
			TheItDepot.mainpage();

			// Get the Ram Price
			TheItDepot.GenericFunctionGetPrice(PropertiesValue("theitdepot_ram"));
			captureScreenShot("theitdepot_ram"+Filecurrentdate); 
			
			Createrow(3);
			WriteDataInExcel("company1", "theitdepot_ram_name", TheItDepot.prices(), currentdate, 0, 3,excelpath);
			System.out.println("Ram Price is  :" + TheItDepot.prices());
			TheItDepot.mainpage();

			// Get the Cabinet Price
			TheItDepot.GenericFunctionGetPrice(PropertiesValue("theitdepot_cabinet"));
			captureScreenShot("theitdepot_cabinet"+Filecurrentdate); 
			
			Createrow(4);
			WriteDataInExcel("company1", "theitdepot_cabinet", TheItDepot.prices(), currentdate, 0, 4,excelpath);
			System.out.println("Cabinet Price is  :" + TheItDepot.prices());
			TheItDepot.mainpage();

			// Get the GraphicsCard Price
			TheItDepot.GenericFunctionGetPrice(PropertiesValue("theitdepot_graphicscard"));
			captureScreenShot("theitdepot_graphicscard"+Filecurrentdate); 
			
			Createrow(5);
			WriteDataInExcel("company1", "theitdepot_graphicscard", TheItDepot.prices(), currentdate, 0, 5,excelpath);
			System.out.println("Graphics Card Price is  :" + TheItDepot.prices());
			TheItDepot.mainpage();

			// Get the PowerSupply Price
			TheItDepot.GenericFunctionGetPrice(PropertiesValue("theitdepot_psu"));
			captureScreenShot("theitdepot_powerSupply"+Filecurrentdate); 
			
			Createrow(6);
			WriteDataInExcel("company1", "theitdepot_psu", TheItDepot.prices(), currentdate, 0, 6,excelpath);
			System.out.println("PowerSupply Price is  :" + TheItDepot.prices());
			TheItDepot.mainpage();
		}

		else if (GetTitle().contains("mdcomputers")) {
			
			System.out.println("MdComputers");
			mdcomputers MDComputers = new mdcomputers(driver);
			WriteDataInExcel(4);
			// Processor
			MDComputers.getproductprices(PropertiesValue("mdcomputer_processor"));
			captureScreenShot("mdcomputer_processor"+Filecurrentdate); 
				
			WriteDataInExcel("company2", "mdcomputer_processor", MDComputers.prices(), currentdate, 4, 1,excelpath);
			System.out.println("Ryzen Processor Price is  :" + MDComputers.prices());
			MDComputers.mainpage();

			// motherboard
			MDComputers.getproductprices(PropertiesValue("mdcomputer_motherboard"));
			captureScreenShot("mdcomputer_motherboard"+Filecurrentdate); 
			WriteDataInExcel("company2", "mdcomputer_motherboard", MDComputers.prices(), currentdate, 4, 2,excelpath);
			System.out.println("Motherboard Price is  :" + MDComputers.prices());
			MDComputers.mainpage();

			// mdcomputer_ram
			MDComputers.getproductprices(PropertiesValue("mdcomputer_ram"));
			captureScreenShot("mdcomputer_ram"+Filecurrentdate); 
						WriteDataInExcel("company2", "mdcomputer_ram", MDComputers.prices(), currentdate, 4, 3,excelpath);
			System.out.println("RAM Price is  :" + MDComputers.prices());
			MDComputers.mainpage();

			// mdcomputer_case
			MDComputers.getproductprices(PropertiesValue("mdcomputer_case"));
			captureScreenShot("mdcomputer_case"+Filecurrentdate); 
			
			WriteDataInExcel("company2", "mdcomputer_case", MDComputers.prices(), currentdate, 4, 4,excelpath);
			System.out.println("Cabinet Price is  :" + MDComputers.prices());
			MDComputers.mainpage();

			// mdcomputer_graphicscard
			MDComputers.getproductprices(PropertiesValue("mdcomputer_graphicscard"));
			captureScreenShot("mdcomputer_graphicsCard"+Filecurrentdate); 
			
			WriteDataInExcel("company2", "mdcomputer_graphicscard", MDComputers.prices(), currentdate, 4, 5,excelpath);
			System.out.println("GraphicsCard Price is  :" + MDComputers.prices());
			MDComputers.mainpage();

			// PSU
			MDComputers.getproductprices(PropertiesValue("mdcomputer_psu"));
			captureScreenShot("mdcomputer_psu"+Filecurrentdate); 
			
			WriteDataInExcel("company2", "mdcomputer_psu", MDComputers.prices(), currentdate, 4, 6,excelpath);
			System.out.println("Power Supply Unit Price is  :" + MDComputers.prices());
			MDComputers.mainpage();

		} else if (GetTitle().contains("primeabgb")) {
			primebgb PrimeBGB = new primebgb(driver);
			WriteDataInExcel(8);
			
			
			// Processor
			PrimeBGB.getproductprices(PropertiesValue("primebgb_processor"));
			captureScreenShot("primebgb_processor"+Filecurrentdate); 
			
			String s1=PrimeBGB.prices();
			WriteDataInExcel("company3", "primebgb_processor", s1, currentdate, 8, 1,excelpath);
			System.out.println("Ryzen Processor Price is  :" + s1);
			PrimeBGB.mainpage();


			// motherboard
			PrimeBGB.getproductprices(PropertiesValue("primebgb_motherboard"));
			captureScreenShot("primebgb_motherboard"+Filecurrentdate);
			String s2=PrimeBGB.prices();
			WriteDataInExcel("company3", "primebgb_motherboard", s2, currentdate, 8, 2,excelpath);
			System.out.println("Motherboard Price is  :" + s2);
			PrimeBGB.mainpage();

			// mdcomputer_ram
			PrimeBGB.getproductprices(PropertiesValue("primebgb_ram"));
			captureScreenShot("primebgb_ram"+Filecurrentdate);
			String s3=PrimeBGB.prices();
			WriteDataInExcel("company3", "primebgb_ram", s3, currentdate, 8, 3,excelpath);
			System.out.println("RAM Price is  :" + s3);
			PrimeBGB.mainpage();

			// mdcomputer_case
			PrimeBGB.getproductprices(PropertiesValue("primebgb_case"));
			captureScreenShot("primebgb_case"+Filecurrentdate);
			String s4=PrimeBGB.prices();
			WriteDataInExcel("company3", "primebgb_case", s4, currentdate, 8, 4,excelpath);
			System.out.println("Cabinet Price is  :" + s4);
			PrimeBGB.mainpage();

			// mdcomputer_graphicscard
			PrimeBGB.getproductprices(PropertiesValue("primebgb_graphicscard"));
			captureScreenShot("primebgb_graphicsCard"+Filecurrentdate);
			String s5=PrimeBGB.prices();
			WriteDataInExcel("company3", "primebgb_graphicscard", s5, currentdate, 8, 5,excelpath);
			System.out.println("GraphicsCard Price is  :" + s5);
			PrimeBGB.mainpage();

			// PSU
			PrimeBGB.getproductprices(PropertiesValue("primebgb_psu"));
			captureScreenShot("primebgb_psu"+Filecurrentdate);
			String s6=PrimeBGB.prices();
			WriteDataInExcel("company3", "primebgb_psu", s6, currentdate, 8, 6,excelpath);
			System.out.println("Power Supply Unit Price is  :" + s6);
			PrimeBGB.mainpage();

			
			
		} else if (GetTitle().contains("Amazon")) {
			amazon Amazon = new amazon(driver);
			WriteDataInExcel(12);
		}

	}


	
	@AfterClass
	public void endTest() {
		quitBrowser();
	}

}
