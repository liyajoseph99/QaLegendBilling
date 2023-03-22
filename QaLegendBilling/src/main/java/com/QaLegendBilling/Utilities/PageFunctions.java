package com.QaLegendBilling.Utilities;

import org.openqa.selenium.WebDriver;

import com.QaLegendBilling.Constants.Constants;
import com.QaLegendBilling.Pages.ProductsPage;

public class PageFunctions {
	
	public WebDriver driver;
	ProductsPage objProducts;
	String productTestdataSheet=Constants.SHEET2;	
	
	public PageFunctions(WebDriver driver) { 					 
		this.driver=driver;		 
	}
	
	public String productPageAddNewProductFunctions() {
		objProducts = new ProductsPage(driver);
		objProducts.clickProducts();
		objProducts.clickListProducts();
		objProducts.clickAddProducts();
		String productname=ExcelUtilities.getCellStringData(1, 0,productTestdataSheet);
		objProducts.setProductName(ExcelUtilities.getCellStringData(1, 0,productTestdataSheet));
		objProducts.setBrand(ExcelUtilities.getCellStringData(1, 1,productTestdataSheet));
		objProducts.setUnit(ExcelUtilities.getCellStringData(1, 2,productTestdataSheet));
		objProducts.setCategory(ExcelUtilities.getCellStringData(1, 3,productTestdataSheet));
		objProducts.setAlertQuantity(Integer.toString(ExcelUtilities.getCellNumericData(1, 4,productTestdataSheet)));
		objProducts.setExcTax(Integer.toString(ExcelUtilities.getCellNumericData(1, 5,productTestdataSheet)));
		objProducts.setIncTax(Integer.toString(ExcelUtilities.getCellNumericData(1, 6,productTestdataSheet)));
		objProducts.clickSave();
		return productname;
	}
}
