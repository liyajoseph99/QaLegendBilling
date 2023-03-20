package com.QaLegendBilling.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.ExpensesPage;
import com.QaLegendBilling.Pages.ProductsPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProductsExpenseTest extends LoginTest{

	//this class is for testing - parallel - methods
	
	ProductsPage objProducts;	
	ExpensesPage objExpenses;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	
  @Test(description = "Verify newly added unit is listed", priority = 11,dependsOnMethods = "verifyLoginValidUserValidPassword",
		  groups = {"smoke"}) 
  public void addUnits()  {
	objProducts = new ProductsPage(driver);
	objProducts.clickProducts();
	String unitAddedMsgActual=objProducts.addUnits();
	Assert.assertEquals(unitAddedMsgActual, Constants.UNITADDEDMSGEXPECTED);
	extentTest.get().log(Status.PASS, ExtentLogMessage.UNIT_ADDED_SUCCESS);
	extentTest.get().assignCategory("smoke");
  }
  
  @Test(description = "Verify newly added expense is listed", priority = 12,dependsOnMethods = "verifyLoginValidUserValidPassword",
		  groups = {"smoke"}) 
  public void addExpenses()  {
	  objExpenses = new ExpensesPage(driver);
	  objExpenses.clickExpenses();
	  String expenseAddMsgActual=objExpenses.addExpenses();
	  Assert.assertEquals(expenseAddMsgActual, Constants.EXPENSEADDEDMSGEXPECTED);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.EXPENSE_ADDED_SUCCESS);
	  extentTest.get().assignCategory("smoke");
  }
}
