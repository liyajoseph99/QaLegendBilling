package com.QaLegendBilling.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.UsersPage;
import com.QaLegendBilling.Utilities.PageFunctions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class UsersPageTest extends TestBase {
	
	PageFunctions objUserspage;
	UsersPage objUsers;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	
  @Test(description = "Verify newly added user is listed", priority = 6,enabled=true,
		  groups = {"smoke"},
		  retryAnalyzer = com.QaLegendBilling.Listners.ReTryAnalyzer.class) 
  public void verifyAddingNewUser()  {
	 objUserspage = new PageFunctions(driver);
	 String email=objUserspage.usersPageNewProductFunctions();
	 objUsers = new UsersPage(driver);
	 Boolean searchInfo=objUsers.searchUser(email);
	 Assert.assertTrue(searchInfo);
	 extentTest.get().log(Status.PASS, ExtentLogMessage.ADD_USER_SUCCESS);
	 extentTest.get().assignCategory("smoke");
  }
  
  @Test(description = "Verify newly added role is listed", priority = 7,enabled=true,groups = {"regression"})
  public void verifyAddingNewRole()  {
	  objUsers.clickRoles();
	  objUsers.clickAddBtn();
	  objUsers.addNewRole(Constants.ROLENAME);
	  objUsers.saveRole();
	  Boolean searchInfo=objUsers.searchRole(Constants.ROLENAME);
	  Assert.assertTrue(searchInfo);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.ADD_ROLE_SUCCESS);
	  extentTest.get().assignCategory("regression");
  }
  
  @Test(description = "Verify newly added role is deleted successfully", priority = 8,enabled=true,groups = {"regression"})
  public void verifyDeletingNewRole() {
	  String searchinfoDelete=objUsers.deleteRole(Constants.ROLENAME);
	  Assert.assertEquals(searchinfoDelete, Constants.SERACHINFOROLEDELETE);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.DELETE_ROLE_SUCCESS);
	  extentTest.get().assignCategory("regression");
  }
}
