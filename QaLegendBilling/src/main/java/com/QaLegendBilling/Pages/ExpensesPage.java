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
	@FindBy(xpath="//strong[text()='Total:']")
	WebElement totalExpense;
	@FindBy(id="footer_total_due")
	WebElement totalExpenseInFigure;
	@FindBy(xpath="//a[text()='Expense Categories']")
	WebElement expenseCategories;
	@FindBy(xpath="//*[@id=\"expense_category_table\"]/tbody/tr[1]/td[3]/button[1]")
	WebElement editExpenseCategory;
	@FindBy(id="code")
	WebElement categoryCode;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement updateCategoryCode;
	@FindBy(xpath="//div[text()='Expense category updated successfully']")
	WebElement updateSuccessMsg;
	
	public ExpensesPage(WebDriver driver) { 					 
		this.driver=driver;
		PageFactory.initElements(driver, this);				 
	}
	
	public void clickExpenses() {
		WaitUtilities.waitForElementTobeClickable(driver, expenses);
		expenses.click();
	}
	
	public String addExpenses() {
		WaitUtilities.waitForElementTobeClickable(driver, addExpenses);	
		addExpenses.click();
		Select obj=PageUtilities.selectClassDropdown(driver,businessLocation);
		obj.selectByValue(Constants.DECIMALVALUE);
		totalAmount.sendKeys(Constants.TOTALAMOUNT);
		save.click();
		String expenseAddMsgActual=expenseAddedMessage.getText();
		return expenseAddMsgActual;
	}
	
	public boolean ListExpenses() {
		Select obj=PageUtilities.selectClassDropdown(driver,expenseEntryList);
		obj.selectByVisibleText(Constants.LISTEXPENSEPAGE);
		PageUtilities.scrollToTheElement(driver,totalExpenseInFigure);
		Boolean totalExpenseIsDisplayedActual=totalExpenseInFigure.isDisplayed();
		return totalExpenseIsDisplayedActual;
	}
	
	public boolean updateExpenseCategory() {
		expenseCategories.click();
		editExpenseCategory.click();
		categoryCode.clear();
		categoryCode.sendKeys("05");
		updateCategoryCode.click();
		Boolean updateSuccessMsgIsDisplayed=updateSuccessMsg.isDisplayed();
		return updateSuccessMsgIsDisplayed;
	}
	
}
