package com.QaLegendBilling.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.PaymentAccountsPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class PaymentAccountsPageTest extends TestBase{
	
	PaymentAccountsPage objPaymentAccounts;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	
	@Test(description = "Verify supplier due amount is listed same in Balance Sheet and Trial Balance", priority = 15, 
			  groups = {"regression"}) 
	  public void verifySupplierDueAmount()  {
		objPaymentAccounts = new PaymentAccountsPage(driver);
		String balanceSheetSupplierDueAmount=objPaymentAccounts.verifyBalanceSheet();
		String trialBalanceSupplierDueAmount=objPaymentAccounts.verifyTrialBalance();
		Assert.assertEquals(balanceSheetSupplierDueAmount, trialBalanceSupplierDueAmount);
		extentTest.get().log(Status.PASS, ExtentLogMessage.DELETE_ROLE_SUCCESS);
		extentTest.get().assignCategory("regression");
  }
	
	@Test(description = "Verify Link Account functionality against Payment Ref Number in Payment Account Report", priority = 16,
			dependsOnMethods = "verifySupplierDueAmount", groups = {"regression"}) 
	  public void verifyLinkAccountAgainstPaymentRefNumber()  {
		objPaymentAccounts.clickpaymentAccountReport();
		objPaymentAccounts.linkAccount();
	}
}
