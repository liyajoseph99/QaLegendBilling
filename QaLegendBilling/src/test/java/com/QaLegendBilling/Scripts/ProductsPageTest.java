package com.QaLegendBilling.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.ProductsPage;
import com.QaLegendBilling.Utilities.PageFunctions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProductsPageTest extends TestBase{
	
	PageFunctions objProductspage;
	ProductsPage objProducts;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();	
	
	@Test(description = "Verify newly added product is listed", priority = 11,enabled=true,groups = {"smoke"}) 
	  public void verifyAddingNewProduct()  {
		objProductspage = new PageFunctions(driver);
		String productname=objProductspage.productPageAddNewProductFunctions();
		objProducts = new ProductsPage(driver);
		Boolean searchInfo=objProducts.searchProduct(productname);
		Assert.assertTrue(searchInfo);
		extentTest.get().log(Status.PASS, ExtentLogMessage.ADD_PRODUCT_SUCCESS);
		extentTest.get().assignCategory("smoke");
  }
	
	@Test(description = "Verify newly added product is deactivated successfully", priority = 12,enabled=true,groups = {"smoke"}) 
	  public void verifyDeactivatingNewProduct() {
		objProducts = new ProductsPage(driver);
		String actualLabel=objProducts.deactivateNewProduct();
		Assert.assertEquals(actualLabel, Constants.EXPECTEDLABEL);
		extentTest.get().log(Status.PASS, ExtentLogMessage.DEACTIVATE_PRODUCT_SUCCESS);
		extentTest.get().assignCategory("smoke");
	}
	
	@Test(description = "Verify newly added product is deleted successfully", priority = 13,enabled=true,groups = {"smoke"}) 
	  public void verifyDeletingNewProduct() {
		objProducts = new ProductsPage(driver);
		boolean noRecordsActual=objProducts.deleteNewProduct(); 
		Assert.assertTrue(noRecordsActual);
		extentTest.get().log(Status.PASS, ExtentLogMessage.DELETE_PRODUCT_SUCCESS);
		extentTest.get().assignCategory("smoke");
	}
	
	  @Test(description = "Verify newly added unit is listed", priority = 14,groups = {"smoke"}) 
	  public void addUnits()  {
		objProducts = new ProductsPage(driver);
		String unitAddedMsgActual=objProducts.addUnits();
		Assert.assertEquals(unitAddedMsgActual, Constants.UNITADDEDMSGEXPECTED);
		extentTest.get().log(Status.PASS, ExtentLogMessage.UNIT_ADDED_SUCCESS);
		extentTest.get().assignCategory("smoke");
	  }
}
