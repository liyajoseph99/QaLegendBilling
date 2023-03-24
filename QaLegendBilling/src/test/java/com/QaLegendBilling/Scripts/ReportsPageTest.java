package com.QaLegendBilling.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.ReportsPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReportsPageTest extends TestBase{
	
	ReportsPage objReports;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	
	@Test(description = "Verify the displayed total purchase amount when all locations is selected", priority = 17, 
			  groups = {"regression"}) 
	  public void verifySupplierPurchaseAmount()  {
		objReports = new ReportsPage(driver);
		objReports.clickReports();
		objReports.clickPurchaseAndSale();
		objReports.selectAllLocations();
		boolean purchaseAmountflag=objReports.verifyPurchaseAmount();
		Assert.assertTrue(purchaseAmountflag);
		extentTest.get().log(Status.PASS, ExtentLogMessage.VERIFIEDPURCHASEAMOUNT);
		extentTest.get().assignCategory("regression");
  }
	
	@Test(description = "Verify the displayed total due amount when all locations is selected", priority = 18, 
			dependsOnMethods = "verifySupplierPurchaseAmount", groups = {"regression"}) 
	  public void verifySupplierDueAmount()  {
		objReports = new ReportsPage(driver);
		boolean verifyDueAmountFlag=objReports.verifyDueAmount();
		Assert.assertTrue(verifyDueAmountFlag);
		extentTest.get().log(Status.PASS, ExtentLogMessage.VERIFIEDDUEAMOUNT);
		extentTest.get().assignCategory("regression");
	}
	
	@Test(description = "Verify the displayed total purchase amount when demo location is selected", priority = 19, 
			dependsOnMethods = "verifySupplierDueAmount", groups = {"regression"}) 
	  public void verifySupplierPurchaseAmountDemo()  {
		objReports = new ReportsPage(driver);
		objReports.selectDemoLocations();
		boolean purchaseAmountflag=objReports.verifyPurchaseAmountDemo();
		Assert.assertTrue(purchaseAmountflag);
		extentTest.get().log(Status.PASS, ExtentLogMessage.VERIFIEDPURCHASEAMOUNT);
		extentTest.get().assignCategory("regression");
	}
	
	@Test(description = "Verify the displayed total due amount when demo location is selected", priority = 20, 
			dependsOnMethods = "verifySupplierPurchaseAmountDemo", groups = {"regression"}) 
	  public void verifySupplierDueAmountDemo()  {
		objReports = new ReportsPage(driver);
		boolean verifyDueAmountFlag=objReports.verifyDueAmountDemo();
		Assert.assertTrue(verifyDueAmountFlag);
		extentTest.get().log(Status.PASS, ExtentLogMessage.VERIFIEDDUEAMOUNT);
		extentTest.get().assignCategory("regression");
	}
	
}
