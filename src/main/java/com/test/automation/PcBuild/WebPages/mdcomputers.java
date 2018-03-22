package com.test.automation.PcBuild.WebPages;

import java.io.IOException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.PcBuild.TestBase.TestBase;

public class mdcomputers extends TestBase{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement SearchText;
	

	@FindBy(xpath="//*[@id=\"search\"]/div[1]/button/i")
	WebElement SearchClick;
	
		
	@FindBy(xpath="//meta[@itemprop='price']")
	WebElement PriceForTheProduct;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[4]/div/div/div[2]/div[1]/h4/a")
	WebElement ProductLink;

	@FindBy(xpath="//*[@id=\"logo\"]/a/img")
	WebElement HomePage;
	public mdcomputers(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

 
public void getproductprices(String propertiesValue) {
	// TODO Auto-generated method stub
	SearchText.sendKeys(propertiesValue);
	SearchClick.click();
	scrolldown(400);
	ProductLink.click();
	scrolldown(400);
}


public String prices() {

	int length1 = PriceForTheProduct.getAttribute("content").length();
	String CpuPrice = PriceForTheProduct.getAttribute("content").substring(0, length1-3);
	//System.out.println(CpuPrice);
	
	return CpuPrice;

}

public void mainpage() {
	
	//scrollup(0);
	//Actions action = new Actions(driver);
	//action.moveToElement(HomePage).click().perform();
	driver.get("https://www.mdcomputers.in");
	
}


private void scrollup(int height) {
	// TODO Auto-generated method stub
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy("+height+",0)", "");

	
}


public void scrolldown(int height) {
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,"+height+")", "");

}




}
