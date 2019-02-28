package com.tests.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.tests.TestNgTestBase;

public class ScreenshotListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult result) {
		super.onTestFailure(result);
		if (!result.isSuccess())
			makeScreenshot(result, "failure");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		super.onTestSuccess(result);
		if (result.isSuccess())
			makeScreenshot(result, "success");
	}

	private void makeScreenshot(ITestResult result, String type) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();

		File scrFile = ((TakesScreenshot) TestNgTestBase.driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/target/surefire-reports";
			File destFile = new File((String) reportDirectory + "/" + type + "_screenshots/" + methodName + "_"
					+ formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}