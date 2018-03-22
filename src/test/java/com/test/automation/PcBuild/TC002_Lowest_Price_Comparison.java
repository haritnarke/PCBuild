package com.test.automation.PcBuild;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.test.automation.PcBuild.ExcelReader.ReadWriteExcelFile;
import com.test.automation.PcBuild.Logical.LowestPriceComparison;
import com.test.automation.PcBuild.TestBase.TestBase;

public class TC002_Lowest_Price_Comparison extends TestBase{
	
	ReadWriteExcelFile excel;
	LowestPriceComparison lowestpricecompare=new LowestPriceComparison();

	
	@Test
	public void lowestprice() throws IOException {
		
		CreateLowestPriceExcelFile(0);
		WriteDataInExcel(0,excelpath1);
		//System.out.println(excelpath1);
		lowestpricecompare.lowestprice();
		
	}

	
}
