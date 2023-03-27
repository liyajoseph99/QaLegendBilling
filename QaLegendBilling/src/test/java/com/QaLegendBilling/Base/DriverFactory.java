package com.QaLegendBilling.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
  
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public static WebDriver testInitialization(String browser){ //used to initialize the thread-local for the given browser
       
		if(browser.equals("chrome")){	
        	tlDriver.set(new ChromeDriver());
		}
        
		else if(browser.equals("FireFox")){
				tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("edge")){
            tlDriver.set(new EdgeDriver());
        }
		else{
            throw new RuntimeException("Invalid browser");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
	}
	
	public static synchronized WebDriver getDriver() { //used to get driver with thread-local
        return tlDriver.get();
    }
}
