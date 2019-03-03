package com.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tests.TestNgTestBase;
import com.tests.data.Mood;
import com.tests.data.Sex;

/**
 * Sample page
 */
public class HomePage extends Page {
	public WebElement getTitle() {
		return driver
				.findElement(By.xpath("//div[text()='" + TestNgTestBase.messages.getString("HomePage.Title") + "']"));
	}

	@FindBy(className = "freebirdFormviewerViewHeaderDescription")
	@CacheLookup
	public WebElement form;

	@FindBy(className = "freebirdFormviewerViewHeaderRequiredLegend")
	@CacheLookup
	public WebElement required;

	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	public WebElement email;

	@FindBy(id = "i2")
	@CacheLookup
	public WebElement emailErrorMessage;

	@FindBy(id = "i.err.1236342938")
	@CacheLookup
	public WebElement dateErrorMessage;

	@FindBy(id = "i.err.1645109785")
	@CacheLookup
	public WebElement nameErrorMessage;

	@FindBy(id = "i.err.454110266")
	@CacheLookup
	public WebElement sexErrorMessage;

	@FindBy(id = "i.err.1001784558")
	@CacheLookup
	public WebElement moodErrorMessage;

	@FindBy(xpath = "//input[@type='date']")
	@CacheLookup
	public WebElement date;

	@FindBy(xpath = "//input[@type='text']")
	@CacheLookup
	public WebElement name;

	@FindBy(xpath = "//div[@role='presentation' and @jsname='LgbsSe']/div")
	@CacheLookup
	public WebElement sexElement;

	public WebElement getSubmit() {
		return driver
				.findElement(By.xpath("//span[text()='" + TestNgTestBase.messages.getString("HomePage.Submit") + "']"));
	}

	public WebElement getMood(Mood mood) {
		return driver.findElement(By.xpath("//div[@class='exportLabelWrapper' and div/div/span[starts-with(.,'" + mood
				+ "')]]/div[@role='checkbox']"));
	}

	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}

	public void selectSex(Sex sex) {
		sexElement.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(d -> d.findElement(
				By.xpath("//div[contains(@class,'exportSelectPopup') and div/content[text()='" + sex + "']]"))).click();
	}
}