package com.w2a.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports report;
	
	public static ExtentReports getInstance() {
		if(report==null) {
			report=new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			report.loadConfig(new File(System.getProperty("user.dir")+"\\resources\\extentconfig\\ReportsConfig.xml"));
		}
		return report;
	}

}
