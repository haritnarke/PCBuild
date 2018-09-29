package com.test.automation.PcBuild;

import java.io.IOException;

import org.testng.annotations.Test;

import com.test.automation.PcBuild.Logical.TotalCostingCalculationLogic;
import com.test.automation.PcBuild.TestBase.SendingMail;

public class TC0003_Total_Cost_Value extends TotalCostingCalculationLogic{
	
	SendingMail mail=new SendingMail();
	
	@Test
	public void Total_Cost() {
		
		try {
			totalcost();
			SendingMail.sendMail();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
