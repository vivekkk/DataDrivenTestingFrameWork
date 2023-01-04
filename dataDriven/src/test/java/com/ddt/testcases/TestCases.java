package com.ddt.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ddt.base.Base;
import com.ddt.rough.TestProperties;
import com.ddt.utilities.DataProviders;

public class TestCases extends Base {
	

	public TestCases() {
		super();
	
		// TODO Auto-generated constructor stub
	}

	@Test
	public void mgrLogin() throws InterruptedException {

		driver.get(TestProperties.configprop.getProperty("siteUrl"));
		wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(TestProperties.configprop.getProperty("wait"))));
		Actions act = new Actions(driver);
		act.click();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.cssSelector(TestProperties.oRepoprop.getProperty("HPManagerLoginBtn_CSS")))));
		clickonElement("HPManagerLoginBtn_CSS");
		act.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath(TestProperties.oRepoprop.getProperty("AddCustButton_Xpath")))));
		clickonElement("AddCustButton_Xpath");
		Reporter.log("Login to the website is successfull");
		System.out.println(driver.hashCode());
		Assert.assertTrue(isElementPresent(By.xpath(oRepoprop.getProperty("AddCustButton_Xpath"))),
				"Login is not successfull");
		// Assert.fail();
	}




}
