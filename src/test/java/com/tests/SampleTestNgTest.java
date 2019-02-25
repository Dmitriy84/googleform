package com.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tests.pages.HomePage;

public class SampleTestNgTest extends TestNgTestBase {

	private HomePage homepage;

	@BeforeMethod
	public void initPageObjects() {
		homepage = PageFactory.initElements(driver, HomePage.class);
	}

	@Test
	public void testWrongEmail() {
		driver.get(baseUrl);
		homepage.email.sendKeys("test@gmail");
		homepage.title.click();
		Assert.assertEquals(homepage.emailErrorMessage.getText(), "Потрібна дійсна електронна адреса",
				"Unexpected email error message");
		System.out.println();
	}
}
