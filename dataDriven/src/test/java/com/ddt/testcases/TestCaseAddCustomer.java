package com.ddt.testcases;

import java.time.Duration;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ddt.base.Base;
import com.ddt.rough.TestProperties;
import com.ddt.utilities.DataProviders;

public class TestCaseAddCustomer extends Base {
	@Test(dataProviderClass = DataProviders.class, dataProvider = "exceldp")//, dependsOnMethods = { "mgrLogin" })
	//public void addCustomer(String FirstName, String LastName, String PostCode, String Run) throws InterruptedException {
	public void addCustomer(Hashtable<String,String> data) throws InterruptedException {
		if(!data.get("Run").equalsIgnoreCase("y"))
		{
			throw new SkipException("This data is skipped as it is not needed to be executed");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		clickonElement("AddCustButton_Xpath");
		wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(TestProperties.configprop.getProperty("wait"))));
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath(TestProperties.oRepoprop.getProperty("FirstNameTextBox_Xpath")))));
		enterTextToElement("FirstNameTextBox_Xpath", data.get("FirstName"));
		enterTextToElement("LastNameTextBox_CSS",  data.get("LastName"));
		enterTextToElement("PostCodeTextBox_CSS", data.get("PostCode"));
		clickonElement("AddCustomerButton_Xpath");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		System.out.println(driver.hashCode());

	}
}
