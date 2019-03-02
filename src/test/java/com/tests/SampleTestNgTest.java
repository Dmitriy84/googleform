package com.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tests.data.FormData;
import com.tests.data.Mood;
import com.tests.pages.HomePage;
import com.tests.utils.DataFactory;
import com.tests.utils.StringUtils;

public class SampleTestNgTest extends TestNgTestBase {
	private static final String WrongDateAssertMessage = "Unexpected date error message";
	private static final String WrongEmailAssertMessage = "Unexpected email error message";
	private static final String WrongNameAssertMessage = "Unexpected name error message";
	private static final String WrongSexAssertMessage = "Unexpected sex error message";
	private static final String WrongMoodAssertMessage = "Unexpected mood error message";

	private HomePage homepage;

	@BeforeMethod
	public void initPageObjects() {
		homepage = PageFactory.initElements(driver, HomePage.class);
		driver.get(baseUrl);
	}

	@Test
	public void testWrongEmail() {
		homepage.email.sendKeys(StringUtils.randomAlphaNumeric(20, null));
		homepage.getTitle().click();
		Assert.assertEquals(homepage.emailErrorMessage.getText(), messages.getString("WrongEmailMessage"),
				WrongEmailAssertMessage);
	}

	@Test
	public void testMaxCharactersEmail() {
		homepage.email.sendKeys(StringUtils.randomAlphaNumeric(1000, null));
		homepage.getTitle().click();
		Assert.assertEquals(homepage.emailErrorMessage.getText(), messages.getString("WrongEmailMessage"),
				WrongEmailAssertMessage);
	}

	@Test
	public void testCorrectEmail() {
		homepage.email.sendKeys("test@gmail.com");
		homepage.getTitle().click();
		Assert.assertEquals(homepage.emailErrorMessage.getText(), "", WrongEmailAssertMessage);
	}

	@Test
	public void testCorrectDate() {
		homepage.date.sendKeys("12031984");
		homepage.getTitle().click();
		Assert.assertEquals(homepage.date.getText(), "", WrongDateAssertMessage);
	}

	// TODO
	@Test
	public void testWrongDate() throws InterruptedException {
		homepage.date.sendKeys("0000");
		Assert.assertEquals(homepage.date.getText(), messages.getString("WrongDateMessage"), WrongDateAssertMessage);
	}

	@Test
	public void testExidedMaxNameLength() {
		homepage.name.sendKeys(StringUtils.randomAlphaNumeric(21, null));
		// homepage.title.click();
		// TODO
		Assert.assertEquals(homepage.name.getText(), "", WrongDateAssertMessage);
	}

	@Test
	public void testCorrectName() {
		homepage.name.sendKeys("12031984");
		homepage.getTitle().click();
		Assert.assertEquals(homepage.name.getText(), "", WrongNameAssertMessage);
	}

	@Test
	public void testForm() {
		// TODO
		fillForm(DataFactory.getCommon().setMoodSuper(true).setMoodBad(true));
	}

	@Test
	public void checkAllRequiredFields() {
		homepage.getSubmit().click();

		Assert.assertEquals(homepage.emailErrorMessage.getText(), messages.getString("FieldRequiredErrorMessage"),
				WrongEmailAssertMessage);
		Assert.assertEquals(homepage.dateErrorMessage.getText(), messages.getString("FieldRequiredErrorMessage"),
				WrongDateAssertMessage);
		Assert.assertEquals(homepage.nameErrorMessage.getText(), messages.getString("FieldRequiredErrorMessage"),
				WrongNameAssertMessage);
		Assert.assertEquals(homepage.sexErrorMessage.getText(), messages.getString("FieldRequiredErrorMessage"),
				WrongSexAssertMessage);
		Assert.assertEquals(homepage.moodErrorMessage.getText(), messages.getString("FieldRequiredErrorMessage"),
				WrongMoodAssertMessage);
	}

	// TODO test all default values

	private void fillForm(FormData data) {
		homepage.email.sendKeys(data.getEmail());
		homepage.date.sendKeys(String.valueOf(data.getDate()));
		homepage.name.sendKeys(data.getName());
		homepage.selectSex(data.getSex());

		if (data.isMoodSuper())
			homepage.getMood(Mood.Super).click();
		if (data.isMoodGood())
			homepage.getMood(Mood.Good).click();
		if (data.isMoodNormal())
			homepage.getMood(Mood.Normal).click();
		if (data.isMoodSatisfactorily())
			homepage.getMood(Mood.Satisfactorily).click();
		if (data.isMoodBad())
			homepage.getMood(Mood.Bad).click();
	}
}