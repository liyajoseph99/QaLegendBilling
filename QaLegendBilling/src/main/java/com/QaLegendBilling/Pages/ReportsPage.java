package com.QaLegendBilling.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Utilities.PageUtilities;
import com.QaLegendBilling.Utilities.WaitUtilities;

public class ReportsPage {

	public WebDriver driver;
	
	@FindBy(xpath="//span[text()='Reports']")
	WebElement reports;
	@FindBy(xpath="//a[text()='Purchase & Sale']")
	WebElement purchaseAndSale;
	@FindBy(id="purchase_sell_location_filter")
	WebElement location;
	@FindBy(xpath="//span[@class='total_purchase']")
	WebElement totalpurchase;
	@FindBy(xpath="//span[@class='sell_minus_purchase text-danger']")
	WebElement salesPurchase;
	@FindBy(xpath="//span[@class='purchase_due']")
	WebElement totalDue;
	@FindBy(xpath="//span[@class='difference_due text-danger']")
	WebElement salesDue;
	@FindBy(xpath="//span[text()='59,559,845.61 ₹']")
	WebElement totalpurchaseDemo;
	@FindBy(xpath="//span[@class='sell_minus_purchase text-danger']")
	WebElement salesPurchaseDemo;
	@FindBy(xpath="//span[@class='purchase_due']")
	WebElement totalDueDemo;
	@FindBy(xpath="//span[@class='difference_due text-danger']")
	WebElement salesDueDemo;
	
	public ReportsPage(WebDriver driver) { 					 
		this.driver=driver;
		PageFactory.initElements(driver, this);				 
	}
	
	public void clickReports() {
		WaitUtilities.waitForElementTobeClickable(driver, reports);
		reports.click();
	}
	
	public void clickPurchaseAndSale() {
		purchaseAndSale.click();
	}
	
	public void selectAllLocations() {
		Select obj=PageUtilities.selectClassDropdown(driver,location);
		obj.selectByVisibleText(Constants.ALLLOCATIONS);
	}
	
	public void selectDemoLocations() {
		Select obj=PageUtilities.selectClassDropdown(driver,location);
		obj.selectByVisibleText(Constants.DEMOLOCATION);
		WaitUtilities.implicitWait(driver);
	}
	
	public boolean verifyPurchaseAmount() {
		WaitUtilities.waitForElementTobeVisible(driver,totalpurchase);
		WaitUtilities.waitForElementTobeVisible(driver,salesPurchase);
		String totalpurchaseAmount=(totalpurchase.getText()).substring(0, 13);
		String salesPurchaseAmount=(salesPurchase.getText()).substring(1, 14);
		int verifyPurchaseAmountFlag=totalpurchaseAmount.compareToIgnoreCase(salesPurchaseAmount);
		if(verifyPurchaseAmountFlag==0)	{
			return true;
		}		
		else
			return false;
	}
		
	public boolean verifyDueAmount() {
		WaitUtilities.waitForElementTobeVisible(driver,totalDue);
		WaitUtilities.waitForElementTobeVisible(driver,salesDue);
		String totalDueAmount=(totalDue.getText()).substring(0, 13);
		String salesDueAmount=(salesDue.getText()).substring(1, 14);
		int verifyDueAmountFlag=totalDueAmount.compareToIgnoreCase(salesDueAmount);
		if(verifyDueAmountFlag==0)	{
			return true;
		}		
		else
			return false;
	}
	
	public boolean verifyPurchaseAmountDemo() {
		WaitUtilities.waitForElementTobeVisible(driver,totalpurchaseDemo);
		WaitUtilities.waitForElementTobeVisible(driver,salesPurchaseDemo);
		String totalpurchaseAmount=(totalpurchase.getText()).substring(0, 13);
		String salesPurchaseAmount=(salesPurchase.getText()).substring(1, 14);
		int verifyPurchaseAmountFlag=totalpurchaseAmount.compareToIgnoreCase(salesPurchaseAmount);
		if(verifyPurchaseAmountFlag==0)	{
			return true;
		}		
		else
			return false;
	}
		
	public boolean verifyDueAmountDemo() {
		WaitUtilities.waitForElementTobeVisible(driver,totalDueDemo);
		WaitUtilities.waitForElementTobeVisible(driver,salesDueDemo);
		String totalDueAmount=(totalDue.getText()).substring(0, 13);
		String salesDueAmount=(salesDue.getText()).substring(1, 14);
		int verifyDueAmountFlag=totalDueAmount.compareToIgnoreCase(salesDueAmount);
		if(verifyDueAmountFlag==0)	{
			return true;
		}		
		else
			return false;
	}
	
}
