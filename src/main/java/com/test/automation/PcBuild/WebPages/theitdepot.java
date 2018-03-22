package com.test.automation.PcBuild.WebPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.PcBuild.Config.ReadPropertiesFile;

public class theitdepot extends ReadPropertiesFile {

	public WebDriver driver;

	@FindBy(xpath="//input[@class='search-field']")
	WebElement SearchField;

	@FindBy(className = "search-button")
	WebElement SearchClick;

	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement ScrollTillAddToCart;

	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement AddToCart;
	@FindBy(xpath = "//*[@data-snapmint-price]")
	WebElement PriceForTheProduct;

	@FindBy(xpath = "/html/body/header/div[2]/div/div/div[1]/div/a/img")
	WebElement HomePage;

	
	
	public theitdepot(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	
	public void scrolldown(int height) {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,"+height+")", "");

	}
	
	
	
	public void GenericFunctionGetPrice(String productsearch) {

		SearchField.sendKeys(productsearch);
		SearchClick.click();
		scrolldown(400);
		driver.findElement(By.xpath("//img[contains(@title,'"+productsearch+"')]")).click();;

		
	}

	public String prices() {

		String CpuPrice = PriceForTheProduct.getAttribute("data-snapmint-price");
		return CpuPrice;

	}

	public void mainpage() {
		HomePage.click();
	}

}
