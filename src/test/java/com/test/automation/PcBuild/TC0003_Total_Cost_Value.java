package com.test.automation.PcBuild;

import java.io.IOException;

import org.testng.annotations.Test;

import com.test.automation.PcBuild.Logical.TotalCostingCalculationLogic;

public class TC0003_Total_Cost_Value extends TotalCostingCalculationLogic{

	
	@Test
	public void Total_Cost() {
		
		try {
			totalcost();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
