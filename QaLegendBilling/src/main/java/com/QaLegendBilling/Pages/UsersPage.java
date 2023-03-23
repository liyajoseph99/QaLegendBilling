package com.QaLegendBilling.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.QaLegendBilling.Utilities.PageUtilities;

public class UsersPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//span[text()='User Management']")
	WebElement userManagement;
	@FindBy(xpath="//i[@class='fa fa-user']")
	WebElement users;
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addButton;
	@FindBy(id="first_name")
	WebElement firstName;
	@FindBy(id="email")
	WebElement emailValue;
	@FindBy(id="role")
	WebElement roleList;
	@FindBy(id="username")
	WebElement userName;
	@FindBy(id="password")
	WebElement passWordValue;
	@FindBy(id="confirm_password")
	WebElement cnfrmPassword;
	@FindBy(id="submit_user_button")
	WebElement save;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchUser;
	
	@FindBy(xpath="//i[@class='fa fa-briefcase']")
	WebElement roles;
	@FindBy(id="name")
	WebElement roleName;
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	WebElement saveBtn;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchRole;
	@FindBy(xpath="//div[@class='dataTables_info']")
	WebElement searchInfo;
	@FindBy(xpath="//button[text()=' Delete']")
	WebElement delete;
	@FindBy(xpath="//button[text()='OK']")
	WebElement deleteOKButton;
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement searchInfoDelete;
	
	public UsersPage(WebDriver driver) { 					 
		this.driver=driver;
		PageFactory.initElements(driver, this);				 
	}

	public void clickUserManagement() {
		userManagement.click();
	}
	
	public void clickUsers() {
		users.click();
	}
	
	public void clickAddBtn() {
		addButton.click();
	}
	
	public void setFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}
	
	public void setEmail(String email) {
		emailValue.sendKeys(email);
	}
	
	public void setRole(String role) {
		Select obj=PageUtilities.selectClassDropdown(driver,roleList);
		obj.selectByVisibleText(role);
	}
	
	public void setUserName(String username) {
		userName.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passWordValue.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword) {
		cnfrmPassword.sendKeys(confirmPassword);
	}
	
	public void saveNewUser() {
		save.click();
	}
	
	public Boolean searchUser(String email) {
		searchUser.sendKeys(email);
		Boolean searchinfo=searchInfo.isDisplayed();
		return searchinfo;
	}
	
	public void clickRoles() {
		roles.click();
	}
	
	public void addNewRole(String rolename) {
		roleName.sendKeys(rolename);
	}
	
	public void saveRole() {
		saveBtn.click();
	}
	
	public Boolean searchRole(String rolename) {
		searchRole.sendKeys(rolename);
		Boolean searchinfo=searchInfo.isDisplayed();
		return searchinfo;
	}
	
	public String deleteRole(String rolename) {
		searchRole.clear();
		searchRole.sendKeys(rolename);
		delete.click();
		deleteOKButton.click();
		searchRole.clear();
		searchRole.sendKeys(rolename);
		String searchinfoDelete=searchInfoDelete.getText();
		return searchinfoDelete;
	}
}
