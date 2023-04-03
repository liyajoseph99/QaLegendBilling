package com.QaLegendBilling.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Base.TestBase;
import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Constants.ExtentLogMessage;
import com.QaLegendBilling.DataProvider.DataProviders;
import com.QaLegendBilling.Listners.TestListner;
import com.QaLegendBilling.Pages.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginTest extends TestBase {
	
	LoginPage objLogin;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	
  @Test(dataProviderClass = DataProviders.class,dataProvider = "InvalidUserInvalidPassword",enabled=true,
		  description = "verify the login functionality,when invalid username and invalid password is given",priority = 1)
  public void verifyLoginInvalidUserInvalidPassword(String username,String password)  {
	  objLogin=new LoginPage(driver);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clicklogin();
	  Assert.assertEquals(objLogin.getCredentialMisMatchMessage(),Constants.CREDENTIALDONOTMATCHMESSAGE);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
  }
  
  @Test(dataProviderClass = DataProviders.class,dataProvider = "ValidUserInvalidPassword",
		  enabled=true,description = "verify the login functionality,when valid username and invalid password is given",priority = 2)
  public void verifyLoginValidUserInvalidPassword(String username,String password) {
	  objLogin=new LoginPage(driver);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clicklogin();
	  Assert.assertEquals(objLogin.getCredentialMisMatchMessage(),Constants.CREDENTIALDONOTMATCHMESSAGE);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
  }
  
  @Test(dataProviderClass = DataProviders.class,dataProvider = "InvalidUserValidPassword",
		  enabled=true,description = "verify the login functionality,when invalid username and valid password is given",priority = 3)
  public void verifyLoginInvalidUserValidPassword(String username,String password)  {
	  objLogin=new LoginPage(driver);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clicklogin();
	  Assert.assertEquals(objLogin.getCredentialMisMatchMessage(),Constants.CREDENTIALDONOTMATCHMESSAGE);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
  }
  
  @Test(dataProviderClass = DataProviders.class,dataProvider = "ValidUserValidPassword",
		  description = "verify the login functionality,when valid username and valid password is given",priority = 4,
		  groups = {"smoke"})
  public void verifyLoginValidUserValidPassword(String username,String password) {
	  objLogin=new LoginPage(driver);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clicklogin();
	  objLogin.clickEndTour();
	  Assert.assertEquals(objLogin.getHomeTitle(),Constants.HOMETITLE1);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_SUCCESS_MESSAGE);
	  extentTest.get().assignCategory("smoke");
  }
}
