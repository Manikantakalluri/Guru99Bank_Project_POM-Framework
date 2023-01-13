package com.bankmanager.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankmanager.testbase.TestBase;

public class EditAccountPageObject extends TestBase {

	@FindBy(xpath = "//a[text()='Edit Account']")
	private WebElement link_EditAcc;

	@FindBy(xpath = "//input[@name='accountno']")
	private WebElement txt_AccountNo;

	@FindBy(xpath = "//input[@name='AccSubmit']")
	private WebElement btn_Submit;

	public WebElement getLink_EditAcc() {
		return link_EditAcc;
	}

	public WebElement getTxt_AccountNo() {
		return txt_AccountNo;
	}

	public WebElement getBtn_Submit() {
		return btn_Submit;
	}

	public EditAccountPageObject(WebDriver drive) {

		this.driver = driver;

		PageFactory.initElements(drive, this);

	}

	public void editAccPageOperations() {

		getLink_EditAcc().click();
		sleep(3);

		getTxt_AccountNo().sendKeys(getData("AccountNo"));
		sleep(3);

		getBtn_Submit().click();
		sleep(3);

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
