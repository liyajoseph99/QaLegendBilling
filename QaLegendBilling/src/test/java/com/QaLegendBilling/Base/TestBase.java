package com.QaLegendBilling.Base;

import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Utilities.WaitUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.internal.ClassHelper;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	
	public static Properties prop=null;
	public  WebDriver driver;
  
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
  
  
  @BeforeTest(groups = {"smoke"})
  @Parameters({"browser"})
  public void setUp(String browser1) {
	  
	  testBase();    																				
	  
	  if(browser1.equalsIgnoreCase("edge")) {	
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
		 // DriverFactory.getInstance().setDriver(browser1);
		 // driver=DriverFactory.getInstance().getDriver();
		 // System.out.println("in before test:"+driver);
		 // System.out.println("in before test:"+Thread.currentThread().getId());  

	  }
	  else if(browser1.equalsIgnoreCase("chrome")) {														
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	  }
	  
	  else if(browser1.equalsIgnoreCase("gecko")) {														
		 System.setProperty(Constants.GECKOWEBDRIVER, Constants.GECKODRIVERPATH);
		  driver=new FirefoxDriver();
	  }
	  String baseUrl=prop.getProperty("url");
	 // System.out.println("in before test-before url:"+driver);
	  driver.get(baseUrl);
	 // System.out.println("in before test-after url:"+driver);
	  driver.manage().window().maximize();
	  WaitUtilities.implicitWait(driver);
  }

  @AfterTest
  public void tearDown() {
	  DriverFactory.getInstance().closeBrowser();
	  System.out.println("in after test:"+Thread.currentThread().getId());
  }

}
