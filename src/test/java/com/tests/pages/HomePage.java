package com.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.tests.data.Mood;

/**
 * Sample page
 */
public class HomePage extends Page {
	@FindBy(xpath = "//div[text()='Форма регистрации']")
	@CacheLookup
	public WebElement title;

	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	public WebElement email;

	@FindBy(id = "i2")
	@CacheLookup
	public WebElement emailErrorMessage;

	@FindBy(id = "i.err.1236342938")
	@CacheLookup
	public WebElement dateErrorMessage;

	@FindBy(xpath = "//input[@type='date']")
	@CacheLookup
	public WebElement date;

	@FindBy(xpath = "//input[@type='text']")
	@CacheLookup
	public WebElement name;

	@FindBy(xpath = "//content[@class='quantumWizMenuPaperselectContent exportContent']")
	@CacheLookup
	public WebElement sex;

	@FindBy(xpath = "//span[text()='Submit']")
	@CacheLookup
	public WebElement submit;

	public WebElement getMood(Mood moon) {
		return driver.findElement(By.xpath("//div[starts-with(.,'ÐšÐ°Ðº Ð²Ð°ÑˆÐµ Ð½Ð°Ñ�Ñ‚Ñ€Ð¾ÐµÐ½Ð¸Ðµ ? :)')]"));
	}

	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}
}