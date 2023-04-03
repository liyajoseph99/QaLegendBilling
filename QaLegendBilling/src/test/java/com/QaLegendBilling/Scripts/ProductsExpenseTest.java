package com.QaLegendBilling.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.ExpensesPage;
import com.QaLegendBilling.Pages.LoginPage;
import com.QaLegendBilling.Pages.ProductsPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProductsExpenseTest extends LoginTest{

	//this class is for testing - parallel - methods
	ProductsPage objProducts;	
	ExpensesPage objExpenses;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	
  @Test(description = "Verify newly added unit is listed",
		  groups = {"smoke"}) 
  public void verifyAddUnits()  {
	System.out.println("units:"+Thread.currentThread().getId());
	objProducts = new ProductsPage(driver);
	objProducts.clickProducts();
	String unitAddedMsgActual=objProducts.addUnits();
	Assert.assertEquals(unitAddedMsgActual, Constants.UNITADDEDMSGEXPECTED);
	extentTest.get().log(Status.PASS, ExtentLogMessage.UNIT_ADDED_SUCCESS);
	extentTest.get().assignCategory("smoke");
  }
  
  @Test(description = "Verify newly added expense is listed",enabled=true, 
		  groups = {"smoke"}) 
  public void verifyAddExpenses()  {
	  System.out.println("expenses:"+Thread.currentThread().getId());
	  objExpenses = new ExpensesPage(driver);
	  objExpenses.clickExpenses();
	  String expenseAddMsgActual=objExpenses.addExpenses();
	  Assert.assertEquals(expenseAddMsgActual, Constants.EXPENSEADDEDMSGEXPECTED);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.EXPENSE_ADDED_SUCCESS);
	  extentTest.get().assignCategory("smoke");
  }
}