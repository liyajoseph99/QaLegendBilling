package com.QaLegendBilling.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	@FindBy(id = "username")
	WebElement user;
	@FindBy(id = "password")
	WebElement pass;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement login;
	@FindBy(xpath="//button[text()='End tour']")
	WebElement endTour;
	@FindBy(xpath="//strong[text()='These credentials do not match our records.']")
	WebElement credentialErrorMessage;
	
	public LoginPage(WebDriver driver) { 					 
		this.driver=driver;
		PageFactory.initElements(driver, this);				 
	}

	public void setUsername(String username) {
		user.clear();
		user.sendKeys(username);
	}
	
	public void setPassword(String password) {
		pass.clear();
		pass.sendKeys(password);
	}
	
	public void clicklogin() {
		login.click();
	}
	
	public void clickEndTour() {
		endTour.click();
	}
	
	public String getCredentialMisMatchMessage() {
		String credentialerrorMessage=credentialErrorMessage.getText();
		return credentialerrorMessage;
	}
	
	public String getHomeTitle() {
		String homeTitle=driver.getTitle();
		return homeTitle;
	}
}
