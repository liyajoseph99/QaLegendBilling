package com.QaLegendBilling.Scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.ExpensesPage;
import com.QaLegendBilling.Pages.ProductsPage;
import com.QaLegendBilling.Utilities.WaitUtilities;
import com.aventstack.extentreports.ExtentTest;

public class ProductsExpenseTest extends LoginTest{

	//this class is for testing - parallel - methods
	
	ProductsPage objProducts;	
	ExpensesPage objExpenses;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	
  @Test(description = "Verify newly added unit is listed", priority = 11,dependsOnMethods = "verifyLoginValidUserValidPassword") 
  public void addUnits()  {
	objProducts = new ProductsPage(driver);
	objProducts.clickProducts();
	objProducts.addUnits();
  }
  
  @Test(description = "Verify newly added expense is listed", priority = 12,dependsOnMethods = "verifyLoginValidUserValidPassword") 
  public void addExpenses()  {
	  objExpenses = new ExpensesPage(driver);
	  objExpenses.clickExpenses();
	  objExpenses.addExpenses();
  }
}
