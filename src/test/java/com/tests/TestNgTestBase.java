package com.tests;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tests.utils.locale.UTF8Control;

import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

	protected static URL gridHubUrl = null;
	protected static String baseUrl;
	protected static Capabilities capabilities;
	public static final ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", new UTF8Control("ua"));

	public static WebDriver driver;

	@BeforeSuite
	public void initTestSuite() throws IOException {
		SuiteConfiguration config = new SuiteConfiguration();
		baseUrl = config.getProperty("site.url");
		if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
			gridHubUrl = new URL(config.getProperty("grid.url"));
		}
		capabilities = config.getCapabilities();
	}

	@BeforeMethod
	public void initWebDriver() {
		driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
	}

	@AfterMethod
	public void closeWebDriver() {
		driver.close();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		WebDriverPool.DEFAULT.dismissAll();
	}
}
