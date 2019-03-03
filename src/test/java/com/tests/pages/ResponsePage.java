package com.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ResponsePage extends Page {
	public ResponsePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className = "freebirdFormviewerViewResponseConfirmationMessage")
	@CacheLookup
	public WebElement confirmation;
}