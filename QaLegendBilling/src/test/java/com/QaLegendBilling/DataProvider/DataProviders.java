package com.QaLegendBilling.DataProvider;

import org.testng.annotations.DataProvider;

import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Utilities.ExcelUtilities;

public class DataProviders {
	
	String loginTestdataSheet=Constants.SHEET1;	
	
  @DataProvider(name="InvalidUserInvalidPassword")
  public Object[][] verifyLoginInvalidUserInvalidPassword() {
	  String[][] data=new String[1][2];
	  data[0][0]=ExcelUtilities.getCellStringData(0, 0,loginTestdataSheet);
	  data[0][1]=ExcelUtilities.getCellStringData(0, 1,loginTestdataSheet);
	  return data;
  }
  
  @DataProvider(name="ValidUserInvalidPassword")
  public Object[][] verifyLoginValidUserInvalidPassword() {
	  String[][] data=new String[1][2];
	  data[0][0]=ExcelUtilities.getCellStringData(1, 0,loginTestdataSheet);
	  data[0][1]=ExcelUtilities.getCellStringData(1, 1,loginTestdataSheet);
	  return data;
  }
  
  @DataProvider(name="InvalidUserValidPassword")
  public Object[][] verifyLoginInvalidUserValidPassword() {
	  String[][] data=new String[1][2];
	  data[0][0]=ExcelUtilities.getCellStringData(2, 0,loginTestdataSheet);
	  int passwordInt=ExcelUtilities.getCellNumericData(2, 1,loginTestdataSheet);
	  data[0][1]=Integer.toString(passwordInt);
	  return data;
  }
  
  @DataProvider(name="ValidUserValidPassword")
  public Object[][] verifyLoginValidUserValidPassword() {
	  String[][] data=new String[1][2];
	  data[0][0]=ExcelUtilities.getCellStringData(3, 0,loginTestdataSheet);
	  int passwordInt=ExcelUtilities.getCellNumericData(3, 1,loginTestdataSheet);
	  data[0][1]=Integer.toString(passwordInt);
	  return data;
  }
}
