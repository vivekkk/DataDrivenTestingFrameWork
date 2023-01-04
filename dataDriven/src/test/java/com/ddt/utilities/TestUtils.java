package com.ddt.utilities;

import com.ddt.base.Base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtils extends Base {
	public static String filename;
    
	public static String captureScreenshot() throws InterruptedException, IOException 
	{
		StringBuffer name = new StringBuffer("ScreenShot");
		Date date=new Date();
       name.append(date.toString().replace(" ", "_").replace(":", "_")).append(".png");
        filename=name.toString();
        
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 // Thread.sleep(100000);
		System.out.println("driver"+screenshot);
		System.out.println(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+filename);
		File f= new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+filename);
		//System.out.println(f);
		FileUtils.copyFile(screenshot,f );
		System.out.println("Screen shot copied");
		return System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+filename;
	} 
}
