package com.QaLegendBilling.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Utilities.PageUtilities;
import com.QaLegendBilling.Utilities.WaitUtilities;

public class PaymentAccountsPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//span[text()='59,429,712.47 ₹']")
	WebElement balanceSheetSupplierDue;
	@FindBy(xpath="//a[text()='Balance Sheet']")
	WebElement balanceSheet;
	@FindBy(xpath="//a[text()='Trial Balance']")
	WebElement trialBalance;
	@FindBy(xpath="//span[text()='Payment Accounts']")
	WebElement paymentAccounts;
	@FindBy(xpath="//a[text()='Payment Account Report']")
	WebElement paymentAccountReport;
	@FindBy(xpath="//*[@id=\"payment_account_report\"]/tbody/tr[1]/td[6]/button")
	WebElement linkAccount;
	@FindBy(id="account_id")
	WebElement accountId;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save;
	@FindBy(xpath="//div[text()='Account linked successfully']")
	WebElement accountlinkedSuccessMsg;
	
	public PaymentAccountsPage(WebDriver driver) { 					 
		this.driver=driver;
		PageFactory.initElements(driver, this);				 
	}
	
	public String verifyBalanceSheet() {
		WaitUtilities.waitForElementTobeClickable(driver, paymentAccounts);
		paymentAccounts.click();
		WaitUtilities.waitForElementTobeClickable(driver, balanceSheet);
		balanceSheet.click();
		String balanceSheetSupplierDueAmount=((balanceSheetSupplierDue.getText()).substring(0,13));
		return balanceSheetSupplierDueAmount;
	}
	
	public String verifyTrialBalance() {
		WaitUtilities.waitForElementTobeClickable(driver, trialBalance);
		trialBalance.click();
		String trialBalanceSupplierDueAmount=((balanceSheetSupplierDue.getText()).substring(0,13));
		return trialBalanceSupplierDueAmount;
	}
	
	public void clickpaymentAccountReport() {
		paymentAccountReport.click();
	}
	
	public void linkAccount() {
		linkAccount.click();
		Select obj=PageUtilities.selectClassDropdown(driver,accountId);
		obj.selectByVisibleText(Constants.ACCOUNTID);
		save.click();
		boolean accountLinkedSuccess=accountlinkedSuccessMsg.isDisplayed();
		System.out.println(accountLinkedSuccess);
	}
}
