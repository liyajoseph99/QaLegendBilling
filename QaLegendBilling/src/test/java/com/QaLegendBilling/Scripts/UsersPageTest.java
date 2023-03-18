package com.QaLegendBilling.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.UsersPage;
import com.QaLegendBilling.Utilities.RandomUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class UsersPageTest extends TestBase {
	
	UsersPage objUsers;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	
  @Test(description = "Verify newly added user is listed", priority = 5,enabled=false,
		  groups = {"smoke"},
		  retryAnalyzer = com.QaLegendBilling.Listners.ReTryAnalyzer.class) 
  public void addNewUser() throws IOException  {
	 objUsers = new UsersPage(driver);
	 objUsers.clickUserManagement();
	 objUsers.clickUsers();
	 objUsers.clickAddBtn();
	 String firstname=RandomUtilities.getfName();
	 String email=RandomUtilities.getRandomEmail();
	 String role=Constants.ROLE;
	 String username=RandomUtilities.getusername();
	 String password=RandomUtilities.getpassword();
	 objUsers.setFirstName(firstname);
	 objUsers.setEmail(email);
	 objUsers.setRole(role);
	 objUsers.setUserName(username);
	 objUsers.setPassword(password);
	 objUsers.setConfirmPassword(password);
	 objUsers.saveNewUser();
	 Boolean searchInfo=objUsers.searchUser(email);
	 Assert.assertTrue(searchInfo);
	 extentTest.get().log(Status.PASS, ExtentLogMessage.ADD_USER_SUCCESS);
	 extentTest.get().assignCategory("smoke");
  }
  
  @Test(description = "Verify newly added role is listed", priority = 6,enabled=false,groups = {"regression"})
  public void addNewRole() throws IOException  {
	  objUsers.clickRoles();
	  objUsers.clickAddBtn();
	  objUsers.addNewRole(Constants.ROLENAME);
	  objUsers.saveRole();
	  Boolean searchInfo=objUsers.searchRole(Constants.ROLENAME);
	  Assert.assertTrue(searchInfo);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.ADD_ROLE_SUCCESS);
	  extentTest.get().assignCategory("regression");
  }
  
  @Test(description = "Verify newly added role is deleted successfully", priority = 7,enabled=false)
  public void deleteNewRole() throws IOException  {
	  String searchinfoDelete=objUsers.deleteRole(Constants.ROLENAME);
	  Assert.assertEquals(searchinfoDelete, Constants.SERACHINFOROLEDELETE);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.DELETE_ROLE_SUCCESS);
  }
}
