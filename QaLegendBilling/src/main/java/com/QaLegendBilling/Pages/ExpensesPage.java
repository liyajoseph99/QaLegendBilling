package com.QaLegendBilling.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Utilities.PageUtilities;
import com.QaLegendBilling.Utilities.WaitUtilities;

public class ExpensesPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//span[text()='Expenses']")
	WebElement expenses;
	@FindBy(xpath="//a[text()='Add Expenses']")
	WebElement addExpenses;
	@FindBy(xpath="//select[@name='location_id']")
	WebElement businessLocation;
	@FindBy(id="final_total")
	WebElement totalAmount;
	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
	@FindBy(xpath="//div[@class='toast-message']")
	WebElement expenseAddedMessage;
	@FindBy(xpath="//select[@name='expense_table_length']")
	WebElement expenseEntryList;
	
	public ExpensesPage(WebDriver driver) { 					 
		this.driver=driver;
		PageFactory.initElements(driver, this);				 
	}
	
	public void clickExpenses() {
		WaitUtilities.waitForElementTobeClickable(driver, expenses);
		expenses.click();
	}
	
	public String addExpenses() {
		addExpenses.click();
		Select obj=PageUtilities.selectClassDropdown(driver,businessLocation);
		obj.selectByValue(Constants.DECIMALVALUE);
		totalAmount.sendKeys(Constants.TOTALAMOUNT);
		save.click();
		String expenseAddMsgActual=expenseAddedMessage.getText();
		return expenseAddMsgActual;
	}
	
	public void ListExpenses() {
		Select obj=PageUtilities.selectClassDropdown(driver,expenseEntryList);
		obj.selectByVisibleText("50");
	}
	
}
