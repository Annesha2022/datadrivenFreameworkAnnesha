package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.w2a.utilities.ExtentManager;

import org.apache.log4j.Logger;

public class baseclass {
	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static Properties locatorprop=new Properties();
	public FileInputStream fin;
	public static WebDriverWait wait;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static ExtentReports reo=ExtentManager.getInstance();
	public static ExtentTest test;
	//public FileInputStream fin1;
	@BeforeSuite
	public void initializeDriver() {
		if(driver==null) {
			
			try {
				 fin=new FileInputStream("C:\\Java\\Annesha\\DataDrivenFreameworkAnnesha\\src\\test\\resources\\Properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				prop.load(fin);
				log.debug("prop file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				fin=new FileInputStream("C:\\Java\\Annesha\\DataDrivenFreameworkAnnesha\\src\\test\\resources\\Properties\\locator.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				locatorprop.load(fin);
				log.debug("locator file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver/chromedriver.exe");
				
				driver=new ChromeDriver();
			
			}
			driver.get(prop.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			log.debug("driver maximize");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wait=new WebDriverWait(driver,30);
		}
	
	}

}
