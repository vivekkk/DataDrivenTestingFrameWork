package com.ddt.utilities;

import java.io.File;
import java.io.FileNotFoundException;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	public static ExtentReports extent;
	
	public static ExtentReports getInstance() throws FileNotFoundException
	{
		if (extent==null)
		{
			extent=new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+ "extentReport.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extent-config.xml"));
		}
		
		return extent;
	}

}
