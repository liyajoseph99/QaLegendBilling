package com.QaLegendBilling.Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {

	public static void implicitWait(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	}
	
	public static void waitForElementTobeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));  
		wait.until(ExpectedConditions.elementToBeClickable(element));     
	} 
	
	public WebElement waitForElementTobeVisible(WebDriver driver, WebElement elementToBeLoaded)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;
	}
	
	public WebElement waitForElementTobeLoaded(WebDriver driver, WebElement elementToBeLoaded)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(elementToBeLoaded));
		return element;
	}
	
}
