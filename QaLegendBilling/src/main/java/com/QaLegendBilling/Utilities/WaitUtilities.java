package com.QaLegendBilling.Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {

	public static void implicitWait(WebDriver driver) 
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	}
	
	public static void waitForElementTobeClickable(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));  
		wait.until(ExpectedConditions.elementToBeClickable(element));     
	} 
	
	public static WebElement waitForElementTobeVisible(WebDriver driver, WebElement elementToBeLoaded)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement element=wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;
	}
	
	public WebElement waitForElementTobeLoaded(WebDriver driver, WebElement elementToBeLoaded)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(elementToBeLoaded));
		return element;
	}
	
	public static void fluentWait(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30))						
			       .pollingEvery(Duration.ofSeconds(5))						
			       .ignoring(NoSuchElementException.class);					

			   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {	   
			     public WebElement apply(WebDriver driver) {										
			    	 if(element.isDisplayed()){		
			    		 return element;		    		 
			    	 }
			    	 else {
			    		 return null;		       
			        }
			     }
			   });
	}
}
