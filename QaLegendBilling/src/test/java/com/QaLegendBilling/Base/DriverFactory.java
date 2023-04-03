package com.QaLegendBilling.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private DriverFactory() {}
	
	private static DriverFactory instance=new DriverFactory();
	public static DriverFactory getInstance() {
		return instance;
	}
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public void setDriver(String browser){ //used to initialize the thread-local for the given browser
       
		if(browser.equalsIgnoreCase("chrome")){	
			driver.set(new ChromeDriver());
		}
        
		else if(browser.equalsIgnoreCase("FireFox")){
			driver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
        }
		else{
            throw new RuntimeException("Invalid browser");
        }
      //  getDriver().manage().deleteAllCookies();
      //  getDriver().manage().window().maximize();
      //  return getDriver();
	}
	
	public  WebDriver getDriver() { //used to get driver with thread-local
        return driver.get();
    }
	
	public  void closeBrowser() {
		getDriver().close();
		driver.remove();
	}
}
