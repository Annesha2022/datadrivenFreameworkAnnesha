package com.w2a.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.baseclass;
import com.w2a.utilities.compare;



public class AddCustomer extends baseclass {

	
	/*public AddCustomer(WebDriver driver) {
		this.driver=driver;
	}*/
	@Test(dataProvider="datacollect")
	public void addCustomertestdata(String fname,String lname,String pincode) {
		System.out.println("bankManagerLogin test");
		driver.findElement(By.xpath(locatorprop.getProperty("addcustomerlink"))).click();
		System.out.println("xpath is"+locatorprop.getProperty("FirstNametxt"));
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(fname);
		driver.findElement(By.xpath(locatorprop.getProperty("lastNametxt"))).sendKeys(lname);
		driver.findElement(By.xpath(locatorprop.getProperty("PostCodetxt"))).sendKeys(pincode);
		driver.findElement(By.xpath(locatorprop.getProperty("submitlnk"))).click();
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains("Customer added successfully"));
		//Assert.assertTrue(condition);
		alert.accept();
	}


@DataProvider(name="datacollect")
public Object[][] getData() {
	Object[][] data= {{"annesha","pal","4545"},{"annnesha","pal","4545"},{"annnesha","pal","4545"}};
	return data;
}
}



