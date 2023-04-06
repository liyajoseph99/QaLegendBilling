package com.QaLegendBilling.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.DataProvider.DataProviders;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.ExpensesPage;
import com.QaLegendBilling.Pages.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExpensePageTest extends TestBase{
	
	ExpensesPage objExpenses;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	 
  @Test(description = "Verify newly added expense is listed", priority = 5, 
		  groups = {"smoke"}) 
  public void verifyAddingNewExpenses()  {
	  objExpenses = new ExpensesPage(driver);
	  objExpenses.clickExpenses();
	  String expenseAddMsgActual=objExpenses.addExpenses();
	  Assert.assertEquals(expenseAddMsgActual, Constants.EXPENSEADDEDMSGEXPECTED);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.EXPENSE_ADDED_SUCCESS);
	  extentTest.get().assignCategory("smoke");
  }
  
  @Test(description = "Verify newly added expense is listed", priority = 6, dependsOnMethods = "verifyAddingNewExpenses",
		  groups = {"smoke"}) 
  public void verifyPaginationWhenNewExpenseIsAdded()  {
	  objExpenses = new ExpensesPage(driver);
	  boolean totalExpenseIsDisplayedActual=objExpenses.ListExpenses();
	  Assert.assertTrue(totalExpenseIsDisplayedActual);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.EXPENSE_LISTED_SUCCESS);
	  extentTest.get().assignCategory("smoke");
  }
  
  @Test(description = "Verify the expense category is updated successfully", priority = 7, dependsOnMethods = "verifyPaginationWhenNewExpenseIsAdded",
		  groups = {"smoke"}) 
  public void verifyExpenseCategoryUpdation()  {
	  objExpenses = new ExpensesPage(driver);
	  boolean updateSuccessMsgIsDisplayed=objExpenses.updateExpenseCategory();
	  Assert.assertTrue(updateSuccessMsgIsDisplayed);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.UPDATE_CATEGORY_CODE_SUCCESS);
	  extentTest.get().assignCategory("smoke");
  }
}
