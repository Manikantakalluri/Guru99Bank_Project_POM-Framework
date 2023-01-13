package com.bankmanager.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankmanager.testbase.TestBase;

public class EditCustPageObject extends TestBase {

	@FindBy(xpath = "//a[text()='Edit Customer']")
	private WebElement Link_EditCust;

	@FindBy(xpath = "//input[@name='cusid']")
	private WebElement txt_CustId;

	@FindBy(xpath = "//input[@name='AccSubmit']")
	private WebElement btn_Submit;

	public WebElement getLink_EditCust() {
		return Link_EditCust;
	}

	public WebElement getTxt_CustId() {
		return txt_CustId;
	}

	public WebElement getBtn_Submit() {
		return btn_Submit;
	}

	public EditCustPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void editCustPageOperations() {

		getLink_EditCust().click();
		sleep(3);

		getTxt_CustId().sendKeys(getData("CustId"));
		sleep(3);

		getBtn_Submit().click();

		sleep(3);

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
