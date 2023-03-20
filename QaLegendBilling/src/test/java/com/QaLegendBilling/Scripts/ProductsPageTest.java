package com.QaLegendBilling.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.ProductsPage;
import com.QaLegendBilling.Utilities.ExcelUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProductsPageTest extends TestBase{
	
	ProductsPage objProducts;
	String sheet2=Constants.SHEET2;	
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();	
	
	@Test(description = "Verify newly added product is listed", priority = 8,enabled=true) 
	  public void addNewProduct() throws IOException  {
		objProducts = new ProductsPage(driver);
		objProducts.clickProducts();
		objProducts.clickListProducts();
		objProducts.clickAddProducts();
		String productname=ExcelUtilities.getCellStringData(1, 0,sheet2);
		String brandname=ExcelUtilities.getCellStringData(1, 1,sheet2);
		String unitname=ExcelUtilities.getCellStringData(1, 2,sheet2);
		String categoryname=ExcelUtilities.getCellStringData(1, 3,sheet2);
		int alertquantityInt=ExcelUtilities.getCellNumericData(1, 4,sheet2);
		int exctaxInt=ExcelUtilities.getCellNumericData(1, 5,sheet2);
		int inctaxInt=ExcelUtilities.getCellNumericData(1, 6,sheet2);
		String alertquantity=Integer.toString(alertquantityInt);
		String exctax=Integer.toString(exctaxInt);
		String inctax=Integer.toString(inctaxInt);
		objProducts.setProductName(productname);
		objProducts.setBrand(brandname);
		objProducts.setUnit(unitname);
		objProducts.setCategory(categoryname);
		objProducts.setAlertQuantity(alertquantity);
		objProducts.setExcTax(exctax);
		objProducts.setIncTax(inctax);
		objProducts.clickSave();
		Boolean searchInfo=objProducts.searchProduct(productname);
		Assert.assertTrue(searchInfo);
		extentTest.get().log(Status.PASS, ExtentLogMessage.ADD_PRODUCT_SUCCESS);
		extentTest.get().assignCategory("regression");
  }
	
	@Test(description = "Verify newly added product is deactivated successfully", priority = 9,enabled=true) 
	  public void deactivateNewProduct() {
		objProducts = new ProductsPage(driver);
		String actualLabel=objProducts.deactivateNewProduct();
		Assert.assertEquals(actualLabel, Constants.EXPECTEDLABEL);
		extentTest.get().log(Status.PASS, ExtentLogMessage.DEACTIVATE_PRODUCT_SUCCESS);
	}
	
	@Test(description = "Verify newly added product is deleted successfully", priority = 10,enabled=true) 
	  public void deleteNewProduct() {
		objProducts = new ProductsPage(driver);
		boolean noRecordsActual=objProducts.deleteNewProduct(); 
		System.out.println(noRecordsActual);
		Assert.assertTrue(noRecordsActual);
		extentTest.get().log(Status.PASS, ExtentLogMessage.DELETE_PRODUCT_SUCCESS);
	}
}
