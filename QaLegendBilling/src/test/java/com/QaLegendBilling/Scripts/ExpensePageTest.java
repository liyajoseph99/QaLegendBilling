package com.QaLegendBilling.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.ExpensesPage;
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
}
