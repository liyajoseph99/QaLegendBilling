package com.QaLegendBilling.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.LoginPage;
import com.QaLegendBilling.Utilities.ExcelUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginTest extends TestBase {
	
	LoginPage objLogin;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	String loginTestdataSheet=Constants.SHEET1;	
	
  @Test(enabled=false,description = "verify the login functionality,when invalid username and invalid password is given",priority = 1)
  public void verifyLoginInvalidUserInvalidPassword()  {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(0, 0,loginTestdataSheet);
	  String password=ExcelUtilities.getCellStringData(0, 1,loginTestdataSheet);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clicklogin();
	  Assert.assertEquals(objLogin.getCredentialMisMatchMessage(),Constants.CREDENTIALDONOTMATCHMESSAGE);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
  }
  
  @Test(enabled=false,description = "verify the login functionality,when valid username and invalid password is given",priority = 2)
  public void verifyLoginValidUserInvalidPassword() {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(1, 0,loginTestdataSheet);
	  String password=ExcelUtilities.getCellStringData(1, 1,loginTestdataSheet);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clicklogin();
	  Assert.assertEquals(objLogin.getCredentialMisMatchMessage(),Constants.CREDENTIALDONOTMATCHMESSAGE);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
  }
  
  @Test(enabled=false,description = "verify the login functionality,when invalid username and valid password is given",priority = 3)
  public void verifyLoginInvalidUserValidPassword()  {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(2, 0,loginTestdataSheet);
	  int passwordInt=ExcelUtilities.getCellNumericData(2, 1,loginTestdataSheet);
	  String password=Integer.toString(passwordInt);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clicklogin();
	  Assert.assertEquals(objLogin.getCredentialMisMatchMessage(),Constants.CREDENTIALDONOTMATCHMESSAGE);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
  }
  
  @Test(description = "verify the login functionality,when valid username and valid password is given",priority = 4,
		  groups = {"smoke"})
  public void verifyLoginValidUserValidPassword() {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(3, 0,loginTestdataSheet);
	  int passwordInt=ExcelUtilities.getCellNumericData(3, 1,loginTestdataSheet);
	  String password=Integer.toString(passwordInt);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clicklogin();
	  objLogin.clickEndTour();
	  Assert.assertEquals(objLogin.getHomeTitle(),Constants.HOMETITLE1);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_SUCCESS_MESSAGE);
	  extentTest.get().assignCategory("smoke");
  }
}
