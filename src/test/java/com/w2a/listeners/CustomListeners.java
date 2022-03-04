package com.w2a.listeners;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.baseclass;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.TestUtils;

public class CustomListeners extends baseclass implements ITestListener {
	
	public void onTestStart(ITestResult result) {
	//	test=exreport.createTest(result.getName());
		
		test=reo.startTest(result.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"pass");
		
		reo.endTest(test);
		reo.flush();
	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL,result.getName().toUpperCase()+ "FAILED WITH EXCEPTION"+result.getThrowable());
	
		try {
			TestUtils.capturescreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			test.log(LogStatus.FAIL,test.addScreenCapture(TestUtils.capturescreenshot()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		reo.endTest(test);
		reo.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
