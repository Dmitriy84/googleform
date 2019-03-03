package com.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tests.data.FormData;
import com.tests.data.Mood;
import com.tests.data.TestId;
import com.tests.pages.HomePage;
import com.tests.pages.ResponsePage;
import com.tests.utils.DataFactory;
import com.tests.utils.StringUtils;

// TODO describe bugs
// TODO split to functional and non-functional test classes
public class SampleTestNgTest extends TestNgTestBase {
	private static final String CHECKBOX_SHOULD_BE_UNCHECKED = "Checkbox should be unchecked";
	private static final String FIELD_SHOULD_BE_EMPTY = "Field should be empty";
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
	@TestId("TC1")
	public void testWrongEmail() {
		homepage.email.sendKeys(StringUtils.randomAlphaNumeric(20, null));
		homepage.getTitle().click();
		Assert.assertEquals(homepage.emailErrorMessage.getText(), messages.getString("WrongEmailMessage"),
				WrongEmailAssertMessage);
	}

	@Test
	@TestId("TC2")
	public void testBadEmailDomain() {
		homepage.email.sendKeys(StringUtils.randomAlphaNumeric(20, null) + ".1234");
		homepage.getTitle().click();
		Assert.assertEquals(homepage.emailErrorMessage.getText(), messages.getString("WrongEmailMessage"),
				WrongEmailAssertMessage);
	}

	@Test
	@TestId("TC3")
	// Email length should be limited
	public void testMaxCharactersEmail() {
		homepage.email.sendKeys(StringUtils.randomAlphaNumeric(50, null));
		homepage.getTitle().click();
		Assert.assertEquals(homepage.emailErrorMessage.getText(), messages.getString("WrongEmailMessage"),
				WrongEmailAssertMessage);
	}

	@Test
	@TestId("TC4")
	public void testCorrectEmail() {
		homepage.email.sendKeys("test@gmail.com");
		homepage.getTitle().click();
		Assert.assertEquals(homepage.emailErrorMessage.getText(), "", WrongEmailAssertMessage);
	}

	@Test
	@TestId("TC5")
	public void testCorrectDate() {
		homepage.date.sendKeys("12031984");
		homepage.getTitle().click();
		Assert.assertEquals(homepage.date.getText(), "", WrongDateAssertMessage);
	}

	@Test
	@TestId("TC6")
	public void testWrongDate() throws InterruptedException {
		homepage.date.sendKeys("00000000");
		Thread.sleep(1000);
		homepage.date.sendKeys("0");
		Assert.assertEquals(homepage.date.getText(), messages.getString("WrongDateMessage"), WrongDateAssertMessage);
	}

	@Test
	@TestId("TC7")
	public void testExceedMaxNameLength() {
		homepage.name.sendKeys(StringUtils.randomAlphaNumeric(21, null));
		Assert.assertEquals(homepage.nameErrorMessage.getText(), messages.getString("HomePage.Name.MaxLengthMessage"),
				WrongNameAssertMessage);
	}

	@Test
	@TestId("TC8")
	public void testCheckLabelNames() {
		Assert.assertEquals(homepage.getTitle().getText(), messages.getString("HomePage.Name.MaxLengthMessage"),
				"Wrong title name");
		Assert.assertEquals(homepage.form.getText(), messages.getString("HomePage.FormName.Label"), "Wrong form name");
		Assert.assertEquals(homepage.required.getText(), messages.getString("HomePage.Required.Label"),
				"Wrong required field name");
		Assert.assertEquals(homepage.email.getAttribute("aria-label"),
				messages.getString("HomePage.Email.Autocomplete"), "Wrong autocomplete text");
		// TODO check text 'Дата рождения *'
		// TODO check text 'Дата'
		// TODO check text 'Имя *'
		// TODO check text 'Пол *'
		// TODO check text 'Как ваше настроение ? :) *'
	}

	@Test
	@TestId("TC9")
	public void testCorrectName() {
		homepage.name.sendKeys("12031984");
		homepage.getTitle().click();
		Assert.assertEquals(homepage.name.getText(), "", WrongNameAssertMessage);
	}

	@Test(dataProvider = "NotValidDates")
	@TestId("TC10")
	// Bugs
	public void testNotValidDateYear(String set) {
		homepage.date.sendKeys(set);
		Assert.assertEquals(homepage.date.getText(), messages.getString("WrongDateMessage"), WrongDateAssertMessage);
	}

	@Test(dataProvider = "ValidDates")
	@TestId("TC11")
	public void testNotValidDateDay(String set, String expected) {
		homepage.date.sendKeys(set);
		Assert.assertEquals(homepage.date.getAttribute("data-initial-value"), expected, WrongDateAssertMessage);
	}

	@DataProvider
	public Object[][] ValidDates() {
		return new Object[][] { { "9301987", "1987-09-03" }, { "01321990", "1990-01-31" } };
	}

	@DataProvider
	// Past and future
	public Object[][] NotValidDates() {
		return new Object[][] { { "01011000" }, { "020211111" } };
	}

	@Test
	@TestId("TC12")
	public void testHappyPath() {
		fillForm(DataFactory.getCommon().setMoodSuper(true).setMoodBad(true));
		homepage.getSubmit().click();
		String message = PageFactory.initElements(driver, ResponsePage.class).confirmation.getText();
		Assert.assertEquals(message, messages.getString("ResponsePage.ConfirmationMessage"),
				"Unexpected confirmation message");
	}

	@Test
	@TestId("TC13")
	public void testCheckAllRequiredFields() {
		homepage.getSubmit().click();

		String message = messages.getString("FieldRequiredErrorMessage");

		Assert.assertEquals(homepage.emailErrorMessage.getText(), message, WrongEmailAssertMessage);
		Assert.assertEquals(homepage.dateErrorMessage.getText(), message, WrongDateAssertMessage);
		Assert.assertEquals(homepage.nameErrorMessage.getText(), message, WrongNameAssertMessage);
		Assert.assertEquals(homepage.sexErrorMessage.getText(), message, WrongSexAssertMessage);
		Assert.assertEquals(homepage.moodErrorMessage.getText(), message, WrongMoodAssertMessage);
	}

	@Test
	@TestId("TC14")
	public void testCheckAllDefaultValues() {
		Assert.assertEquals(homepage.email.getText(), "", FIELD_SHOULD_BE_EMPTY);
		Assert.assertEquals(homepage.date.getText(), "", FIELD_SHOULD_BE_EMPTY);
		Assert.assertEquals(homepage.name.getText(), "", FIELD_SHOULD_BE_EMPTY);
		Assert.assertEquals(homepage.sexElement.getText(), messages.getString("HomePage.Sex.Default"),
				"Wrong state of the dropbox");

		Assert.assertEquals(homepage.getMood(Mood.Super).getAttribute("aria-checked"), "false",
				CHECKBOX_SHOULD_BE_UNCHECKED);
		Assert.assertEquals(homepage.getMood(Mood.Good).getAttribute("aria-checked"), "false",
				CHECKBOX_SHOULD_BE_UNCHECKED);
		Assert.assertEquals(homepage.getMood(Mood.Normal).getAttribute("aria-checked"), "false",
				CHECKBOX_SHOULD_BE_UNCHECKED);
		Assert.assertEquals(homepage.getMood(Mood.Satisfactorily).getAttribute("aria-checked"), "false",
				CHECKBOX_SHOULD_BE_UNCHECKED);
		Assert.assertEquals(homepage.getMood(Mood.Bad).getAttribute("aria-checked"), "false",
				CHECKBOX_SHOULD_BE_UNCHECKED);
		Assert.assertEquals(homepage.getMood(Mood.Other).getAttribute("aria-checked"), "false",
				CHECKBOX_SHOULD_BE_UNCHECKED);
	}

	private void fillForm(FormData data) {
		homepage.email.sendKeys(data.getEmail());
		homepage.date.sendKeys(String.valueOf(data.getDate()));
		homepage.name.sendKeys(data.getName());
		homepage.selectSex(data.getSex());

		if (data.isMoodSuper() ^ homepage.getMood(Mood.Super).getAttribute("aria-checked").equalsIgnoreCase("true"))
			homepage.getMood(Mood.Super).click();
		if (data.isMoodGood() ^ homepage.getMood(Mood.Good).getAttribute("aria-checked").equalsIgnoreCase("true"))
			homepage.getMood(Mood.Good).click();
		if (data.isMoodNormal() ^ homepage.getMood(Mood.Normal).getAttribute("aria-checked").equalsIgnoreCase("true"))
			homepage.getMood(Mood.Normal).click();
		if (data.isMoodSatisfactorily()
				^ homepage.getMood(Mood.Satisfactorily).getAttribute("aria-checked").equalsIgnoreCase("true"))
			homepage.getMood(Mood.Satisfactorily).click();
		if (data.isMoodBad() ^ homepage.getMood(Mood.Bad).getAttribute("aria-checked").equalsIgnoreCase("true"))
			homepage.getMood(Mood.Bad).click();
		if (data.getMoodOther() != null)
			homepage.getMood(Mood.Other).sendKeys(data.getMoodOther());
	}
}