package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.w2a.base.baseclass;

public class TestUtils extends baseclass {
	public static String screenshotpath;
	public static String screenshotname;
	public static String destinationpath;

	public static String capturescreenshot() throws IOException {
		Date d=new Date();
		
		 screenshotpath=System.getProperty("user.dir")+"\\resources\\Screenshot\\";
		 screenshotname=d.toString().replace(":", "_").replace("", "_")+".jpg";
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile=screenshotpath+screenshotname;
		File destnFile=new File(destinationFile);
		FileUtils.copyFile(srcfile, destnFile);
		return destinationFile;
		
	}

}
