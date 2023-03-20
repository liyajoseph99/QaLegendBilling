package com.QaLegendBilling.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	public ExpensesPage(WebDriver driver) { 					 
		this.driver=driver;
		PageFactory.initElements(driver, this);				 
	}
	
	public void clickExpenses() {
		WaitUtilities.explicitWait(driver, expenses);
		expenses.click();
	}
	
	public void addExpenses() {
		addExpenses.click();
		Select obj=new Select(businessLocation);
		obj.selectByValue("1");
		totalAmount.sendKeys("1000");
		save.click();
	}
}
