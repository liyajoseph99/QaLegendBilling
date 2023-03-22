package com.QaLegendBilling.Base;

import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Utilities.WaitUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestBase {
	
	public static Properties prop=null;
	public static WebDriver driver;
	
  
  public void testBase() {
	  
	  try
	  {
		prop=new Properties();
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+ Constants.CONFIGPROPPATH); //path of the file config.properties
		prop.load(ip);
	  }
	  catch(FileNotFoundException e)
	  {
		  e.printStackTrace();
	  }
	  catch(IOException e)
	  {
		  e.printStackTrace();
	  }
  }
  
  @AfterMethod
  public void afterMethod(ITestResult r) throws IOException {
	  if(ITestResult.SUCCESS==r.getStatus()) {
			  File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(f, new File(Constants.SCREENSHOTPATH+r.getName()+Constants.SCREENSHOTFORMAT));
		  }
  }
  
  @BeforeTest(groups = {"smoke"})
  @Parameters({"browser"})
  public void beforeTest(String browser1) {
	  
	  testBase();    																				
	  
	  if(browser1.equalsIgnoreCase("edge")) {														
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
	  }
	  else if(browser1.equalsIgnoreCase("chrome")) {														
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	  }
	  
	  else if(browser1.equalsIgnoreCase("gecko")) {														
		 System.setProperty(Constants.GECKOWEBDRIVER, Constants.GECKODRIVERPATH);
		  driver=new FirefoxDriver();
	  }
	  
	  driver.manage().window().maximize();
	  WaitUtilities.implicitWait(driver);
	  
	  String baseUrl=prop.getProperty("url");	
	 // driver = DriverFactory.testInitialization(browser1);
	  driver.get(baseUrl);
  }

  @AfterTest
  public void afterTest() {
  }

}
