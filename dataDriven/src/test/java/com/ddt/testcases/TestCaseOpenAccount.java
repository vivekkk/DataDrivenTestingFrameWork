package com.ddt.testcases;

import java.time.Duration;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ddt.base.Base;
import com.ddt.rough.TestProperties;
import com.ddt.utilities.DataProviders;

public class TestCaseOpenAccount extends Base {
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "exceldp")
	public void openAccount(Hashtable<String,String> data) throws InterruptedException {

		if(!data.get("Run").equalsIgnoreCase("y"))
		{
			throw new SkipException("This data is skipped as it is not needed to be executed");
		}
	
		//namePerson.replaceAll("//s", "");
		System.out.println(driver.hashCode());
		//driver.navigate().refresh();
		String namePerson=data.get("FirstName")+" "+data.get("LastName");
		System.out.println("namePerson: "+namePerson);
		clickonElement("OpenAccountButton_Xpath");
		selectAnOptionFromDropDown("CurrencyDD_Xpath",data.get("Currency"));
		selectAnOptionFromDropDown("CustomerDD_Xpath",namePerson);
		wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(TestProperties.configprop.getProperty("wait"))));
		clickonElement("SubmitButton_Xpath");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		/*Select customerDropdown=new Select(getWebElement("CustomerDD_Xpath"));
		customerDropdown.wait(2000);
		customerDropdown.selectByValue(Name);*/
		

		/*
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * driver.findElement(By.xpath(TestProperties.oRepoprop.getProperty(
		 * "AddCustButton"))).click();
		 * wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.
		 * xpath(TestProperties.oRepoprop.getProperty("FirstNameTextBoxXpath")))));
		 * driver.findElement(By.xpath(TestProperties.oRepoprop.getProperty(
		 * "FirstNameTextBoxXpath"))).sendKeys(Name);
		 * driver.findElement(By.cssSelector(TestProperties.oRepoprop.getProperty(
		 * "LastNameTextBoxCss"))).sendKeys(LastName);
		 * driver.findElement(By.cssSelector(TestProperties.oRepoprop.getProperty(
		 * "PostCodeTextBoxCss"))).sendKeys(PostCode);
		 * driver.findElement(By.xpath(TestProperties.oRepoprop.getProperty(
		 * "AddCustomerButton"))).click(); Alert alert
		 * =wait.until(ExpectedConditions.alertIsPresent()); alert.accept();
		 */
	}

}
