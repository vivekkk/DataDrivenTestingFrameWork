package com.ddt.listners;

import java.io.IOException;
import com.ddt.utilities.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;


import com.ddt.base.Base;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListners implements ITestListener {

	public void onTestStart(ITestResult result) {

		
		Base.test = Base.rep.startTest(result.getName().toUpperCase());
		boolean testRun=Base.isTestExecutable(result.getName());
		if(!testRun)
		{
			throw new SkipException("test skipped from execution "+ result.getName());

		// not implemented
	}
	}

	/**
	 * Invoked each time a test succeeds.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS
	 */
	public void onTestSuccess(ITestResult result) {
		try {
			String screenshotpath = TestUtils.captureScreenshot();
			Base.test.log(LogStatus.PASS, "This test" + result.getName().toUpperCase() + "is Passed");

			Base.test.log(LogStatus.FAIL, Base.test.addScreenCapture(screenshotpath));
			Reporter.log("Capturing Screenshot");
			Reporter.log("<a target=\"_blank\"  href=" + screenshotpath + ">ScreenShot</a>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\"  href=" + screenshotpath + "><image src=" + screenshotpath
					+ " height=200 width=200></a>");
			Base.rep.endTest(Base.test);
			Base.rep.flush();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// not implemented
	}

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#FAILURE
	 */
	public void onTestFailure(ITestResult result) {
		try {
			String screenshotpath = TestUtils.captureScreenshot();
			Base.test.log(LogStatus.FAIL, "This test" + result.getName().toUpperCase() + "is FAIL with exception: "
					+ result.getThrowable().getMessage());
			Base.test.log(LogStatus.FAIL, Base.test.addScreenCapture(screenshotpath));

			Base.test.log(LogStatus.FAIL, Base.test.addScreenCapture(screenshotpath)); // capturing screensot with
																						// extend report.
			Reporter.log("Capturing Screenshot");
			Reporter.log("<a target=\"_blank\"  href=" + screenshotpath + ">ScreenShot</a>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\"  href=" + screenshotpath + "><image src=" + screenshotpath
					+ " height=200 width=200></a>");
			Base.rep.endTest(Base.test);
			Base.rep.flush();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Invoked each time a test is skipped.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SKIP
	 */
	public void onTestSkipped(ITestResult result) {
		// not implemented
		Base.test.log(LogStatus.SKIP, "This test" + result.getName().toUpperCase() + "is SKIP from exception: "
				+ result.getThrowable().getMessage());
	}

	/**
	 * Invoked each time a method fails but has been annotated with
	 * successPercentage and this failure still keeps it within the success
	 * percentage requested.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a test fails due to a timeout.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 */
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	/**
	 * Invoked before running all the test methods belonging to the classes inside
	 * the &lt;test&gt; tag and calling all their Configuration methods.
	 *
	 * @param context The test context
	 */
	public void onStart(ITestContext context) {
		// not implemented
	}

	/**
	 * Invoked after all the test methods belonging to the classes inside the
	 * &lt;test&gt; tag have run and all their Configuration methods have been
	 * called.
	 *
	 * @param context The test context
	 */
	public void onFinish(ITestContext context) {
		// not implemented
	}

}
