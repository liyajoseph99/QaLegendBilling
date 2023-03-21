package com.QaLegendBilling.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Utilities.WaitUtilities;

public class ProductsPage {

	public WebDriver driver;
	public static String productname;
	
	@FindBy(xpath="//span[text()='Products']")
	WebElement products;
	@FindBy(xpath="//i[@class='fa fa-list']")
	WebElement listProducts;
	@FindBy(xpath="//i[@class='fa fa-plus']")
	WebElement addProducts;
	@FindBy(id="name")
	WebElement productName;
	@FindBy(id="brand_id")
	WebElement brand;
	@FindBy(xpath="//select[@name='unit_id']")
	WebElement unit;
	@FindBy(id="category_id")
	WebElement category;
	@FindBy(id="alert_quantity")
	WebElement alertQuantity;
	@FindBy(id="single_dpp")
	WebElement excTax;
	@FindBy(id="single_dpp_inc_tax")
	WebElement incTax;
	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchProduct;
	@FindBy(xpath="//div[@class='dataTables_info']")
	WebElement searchInfo;
	@FindBy(xpath="//input[@class='row-select']")
	WebElement productCheckBox;
	@FindBy(id="deactivate-selected")
	WebElement deactivateProduct;
	@FindBy(xpath="//button[text()='OK']")
	WebElement confirmOK;
	@FindBy(xpath="//span[@class='label bg-gray']")
	WebElement inactiveLabel;
	@FindBy(id="delete-selected")
	WebElement deleteProduct;
	@FindBy(xpath="//div[text()='Deleted Successfully']")
	WebElement deletedMessage;
	@FindBy(xpath="//td[text()='No matching records found']")
	WebElement noRecordsFound;
	@FindBy(xpath="//span[text()='Units']")
	WebElement units;
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addUnits;
	@FindBy(id="actual_name")
	WebElement unitName;
	@FindBy(id="short_name")
	WebElement unitShortName;
	@FindBy(id="allow_decimal")
	WebElement allowDecimal;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement saveUnits;
	@FindBy(xpath="//div[@class='toast-message']")
	WebElement unitAddedMessage;
	
	public ProductsPage(WebDriver driver) { 					 
		this.driver=driver;
		PageFactory.initElements(driver, this);				 
	}
	
	public void clickProducts() {
		WaitUtilities.explicitWait(driver, products);
		products.click();
	}
	
	public void clickListProducts() {
		WaitUtilities.explicitWait(driver, listProducts);
		listProducts.click();
	}
	
	public void clickAddProducts() {
		addProducts.click();
	}
	
	public void setProductName(String productname) {
		productName.sendKeys(productname);
	}
	
	public void setBrand(String brandname) {
		Select obj=new Select(brand);
		obj.selectByVisibleText(brandname);
	}
	
	public void setUnit(String unitname) {
		Select obj=new Select(unit);
		obj.selectByVisibleText(unitname);
	}
	
	public void setCategory(String categoryname) {
		Select obj=new Select(category);
		obj.selectByVisibleText(categoryname);
	}
	
	public void setAlertQuantity(String alertquantity) {
		alertQuantity.sendKeys(alertquantity);
	}
	
	public void setExcTax(String exctax) {
		excTax.sendKeys(exctax);
	}
	
	public void setIncTax(String inctax) {
		incTax.sendKeys(inctax);
	}
	
	public void clickSave() {
		save.click();
	}
	
	public Boolean searchProduct(String productname) {
		this.productname=productname;
		searchProduct.clear();
		searchProduct.sendKeys(productname);
		Boolean searchinfo=searchInfo.isDisplayed();
		return searchinfo;
	}
	
	public String deactivateNewProduct() {
		productCheckBox.click();
		deactivateProduct.click();
		confirmOK.click();
		searchProduct.clear();
		searchProduct.sendKeys(productname);
		String actualLabel=inactiveLabel.getText();
		return actualLabel;
	}
	
	public boolean deleteNewProduct() {
		searchProduct.sendKeys(productname);	
		productCheckBox.click();
		deleteProduct.click();
		confirmOK.click();
		searchProduct.clear();
		searchProduct.sendKeys(productname);
		Boolean noRecordsActual=noRecordsFound.isDisplayed();
		return noRecordsActual;
	}
	
	public String addUnits() {
		units.click();
		addUnits.click();
		unitName.sendKeys(Constants.UNITNAME);
		unitShortName.sendKeys(Constants.UNITNAME);
		Select obj=new Select(allowDecimal);
		obj.selectByValue(Constants.DECIMALVALUE);
		saveUnits.click();
		String unitAddedMsgActual=unitAddedMessage.getText();
		return unitAddedMsgActual;
	}
}
