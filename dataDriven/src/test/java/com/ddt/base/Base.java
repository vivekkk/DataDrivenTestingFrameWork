package com.ddt.base;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ddt.rough.TestProperties;
import com.ddt.utilities.ExcelReading;
import com.ddt.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base extends TestProperties {
	
	public Base() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public static WebDriver driver; // Initilizes the webdriver
	public static ExtentReports rep;  // this is called in before suite method.
	public static ExtentTest test; // define the extend logs
	public  WebDriverWait wait;  // Initialize the wait for the application
	
	public  static void setExtentReport() throws FileNotFoundException
	{
		rep=ExtentManager.getInstance();
	}
	
	
	
	//@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setup() throws InterruptedException
	{
		System.setProperty("org.uncommons.reportng.escape-output", "false");  // if this is not added then ReportNg would not display the html code on report as HTML it would show as text.
		try {
		setExtentReport();
		if(TestProperties.configprop.getProperty("browser").equals("firefox") )
		{
			WebDriverManager.firefoxdriver().setup();
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setAcceptInsecureCerts(true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			logger.info("Set the capabilities");
		    FirefoxOptions fo=new FirefoxOptions();
		    fo.merge(cap);
		   logger.info("Firefox options are merge");
			this.driver =new FirefoxDriver(fo);	
			logger.info("intitalizing the firfoxdriver");
			
		}
		if(TestProperties.configprop.getProperty("browser").equals("chrome") )
		{
			WebDriverManager.chromedriver().setup();
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setAcceptInsecureCerts(true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			logger.info("Set the capabilities for chrome");
		    ChromeOptions co=new ChromeOptions();
		    co.merge(cap);
		   logger.info("chrome options are merge");
			this.driver =new ChromeDriver(co);	
			System.out.println("Initializing the chrome driver");
			logger.error("error intitalizing the chrome capabilities");
			logger.warn("warn intitalizing the chrome capabilities");
		}
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	
	public boolean isElementPresent(By by)
	{
		try {
			
			driver.findElement(by);
			return true;
			
		}
		catch(Throwable th)
		{
			return false;
		}
		
	}
	
	public void clickonElement(String locator)
	{
		if(locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector((TestProperties.oRepoprop.getProperty(locator)))).click();
			test.log(LogStatus.PASS, "Clicked on Element"+ locator+ "successfully ");
		}else if(locator.endsWith("_Xpath"))
		{
			driver.findElement(By.xpath((TestProperties.oRepoprop.getProperty(locator)))).click();
			test.log(LogStatus.PASS, "Clicked on Element"+ locator+ "successfully ");
		}
	}
	
	public void enterTextToElement(String locator, String text)
	{
		if(locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector((TestProperties.oRepoprop.getProperty(locator)))).sendKeys(text);;
			test.log(LogStatus.PASS, "Entered text in text box "+ locator+ "test entered is: "+text + "successfully ");
		}else if(locator.endsWith("_Xpath"))
		{
			driver.findElement(By.xpath((TestProperties.oRepoprop.getProperty(locator)))).sendKeys(text);
			test.log(LogStatus.PASS, "Entered text in text box "+ locator+ "test entered is: "+text + "successfully ");
		}
	}
	
	public WebElement getWebElement(String locator)
	{
		if(locator.endsWith("_CSS"))
		{
			WebElement el=driver.findElement(By.cssSelector((TestProperties.oRepoprop.getProperty(locator))));
			test.log(LogStatus.PASS, "Found the element with locator  "+ locator+  "successfully ");
			return  el;
			
		}else if(locator.endsWith("_Xpath"))
		{
			WebElement el=driver.findElement(By.xpath((TestProperties.oRepoprop.getProperty(locator))));
			test.log(LogStatus.PASS, "Found the element with locator  "+ locator+  "successfully ");
			return el;
			
			
		} else 
			return null;
	}
	
	public void selectAnOptionFromDropDown(String DDlocator, String value) throws InterruptedException
	{
		System.out.println("value from excel"+ value);
		WebElement  DDlocatorEle =getWebElement(DDlocator);
		DDlocatorEle.click();
		Select dropDown=new Select(DDlocatorEle);
		
		/*
		 * List<WebElement> l=dropDown.getAllSelectedOptions();
		 * System.out.println("size="+ l.size()); for(WebElement ele: l) {
		 * System.out.println("Text of the elements" + ele.getText()); }
		 */
		
		dropDown.selectByVisibleText(value);
		test.log(LogStatus.PASS, "Selected the dropdown  "+ DDlocator+ "Value selected is:  "+ value + " Selected successfully ");
	}
	
	@AfterSuite
	public void teardown()
	{
		//driver.quit();
		logger.error("Browser is closed...");
	}
	
	public static boolean isTestExecutable(String testName)
	{
		ExcelReading ex;
		try {
			ex = new ExcelReading(TestProperties.configprop.getProperty("CustDataExcelPath"));
			XSSFSheet sheet1 = ex.getSheet("isRunnable");
			ex.sheet = sheet1;
			String sheetname = sheet1.getSheetName();
			System.out.println("SheetName is : " + ex.sheet.getSheetName());
			// Base.test.log(null, sheet1.getSheetName());
			int rownum = ex.getTotalrowNumb(sheet1);
			int colnum = ex.getTotalcolNum(sheet1);
			for (int i = 0; i <= rownum ; i++) {
				for (int j = 0; j <= colnum - 1; j++) {
					System.out.println((ex.getData(sheetname, i, j) +" " + ex.getData(sheetname, i, j+1)));
					if (ex.getData(sheetname, i, j).equalsIgnoreCase(testName) && ex.getData(sheetname, i, j+1).equalsIgnoreCase("y"))
					{
					
						return true;
					}
				}
				
			}

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
