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
	
	public static void explicitWait(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));  //explicit wait
		wait.until(ExpectedConditions.elementToBeClickable(element));     
	} 
}
