package com.bankmanager.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankmanager.testbase.TestBase;

public class NewAccountPageObject extends TestBase {

	@FindBy(xpath = "//a[text()='New Account']")
	private WebElement link_NewAccount;

	@FindBy(xpath = "//input[@name='cusid']")
	private WebElement txt_CustId;

	public WebElement getLink_NewAccount() {
		return link_NewAccount;
	}

	public WebElement getTxt_CustId() {
		return txt_CustId;
	}

	public WebElement getSelcet_AccType() {
		return selcet_AccType;
	}

	public WebElement getTxt_IntialDeposit() {
		return txt_IntialDeposit;
	}

	public WebElement getBtn_Submit() {
		return btn_Submit;
	}

	@FindBy(xpath = "//select[@name='selaccount']")
	private WebElement selcet_AccType;

	@FindBy(xpath = "//input[@name='inideposit']")
	private WebElement txt_IntialDeposit;

	@FindBy(xpath = "//input[@name='button2']")
	private WebElement btn_Submit;

	public NewAccountPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void newAccPageOperations() {

		getLink_NewAccount().click();
		sleep(5);

		getTxt_CustId().sendKeys("12345");
        getTxt_IntialDeposit().sendKeys("10000");
		getBtn_Submit().click();
		sleep(3);

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
