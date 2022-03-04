package com.w2a.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.w2a.base.baseclass;

public class BankManagerLogin extends baseclass{
	
	@Test
	public void bankManagerLogin() throws InterruptedException {
		System.out.println("bankManagerLogin test");
		System.out.println("xpath is"+locatorprop.getProperty("FirstNametxt"));
		driver.findElement(By.xpath(locatorprop.getProperty("bankmanagerLogin"))).sendKeys("gfgf");;

		Thread.sleep(4000);
	}

}
