package com.test.automation.PcBuild.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class primebgb {

	public WebDriver driver;
	
	@FindBy(xpath="//*[@id='st-container']/div[1]/div/div/div/div[2]/header/div/div/div/div[4]/div[1]/div[2]/div/a/span")
	WebElement SearchClick;
	
	@FindBy(xpath="//input[@value='Search for...']")
	WebElement SearchField;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement SearchSubmit;
	
	
	@FindBy(xpath="//meta[@itemprop='price']")
	WebElement PriceForTheProduct;
	
	@FindBy(xpath="//*[starts-with(@id,'product')]/div[1]/div/div[1]/div[2]/div/div/div[2]/p/span")
	WebElement PriceForTheProduct1;
	
	
	@FindBy(xpath="//*[starts-with(@id,'product')]/div[1]/div/div[1]/div[2]/div/div/div[3]/p/span")
	WebElement PriceForTheProduct2;
	
	public primebgb(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	
	public void scrolldown(int height) {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,"+height+")", "");

	}
	
	
	
	public void getproductprices(String propertiesValue) {

		waitcondition();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", SearchClick);
		//SearchClick.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SearchField.sendKeys(propertiesValue);
		SearchSubmit.click();
		

		
	}

	public String prices() {

		String CpuPrice;
		/*try {
			CpuPrice = PriceForTheProduct.getText().substring(1);
		} catch (Exception e) {
			try {
				CpuPrice = PriceForTheProduct1.getText().substring(1);
				return CpuPrice;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				CpuPrice = PriceForTheProduct2.getText().substring(1);
				return CpuPrice;
			}
		}*/
		
		CpuPrice = PriceForTheProduct.getAttribute("content");
		return CpuPrice;

	}

	
	public void mainpage() {
		driver.get("https://www.primeabgb.com/");
	}

	
	public void waitcondition() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(SearchClick));
	}
}
