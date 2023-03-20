package com.QaLegendBilling.Utilities;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PageUtilities {
	public class DateUtility {
	    public String getSystemDate() {
	        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        Date currentDateWithTime = new Date();
	        String systemDate = dateFormat.format(currentDateWithTime);
	        return systemDate;
	    }
	}
}
