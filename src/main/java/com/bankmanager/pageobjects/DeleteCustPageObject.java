package com.bankmanager.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankmanager.testbase.TestBase;

public class DeleteCustPageObject extends TestBase {

	@FindBy(xpath = "//a[text()='Delete Customer']")
	private WebElement link_DelCust;

	@FindBy(xpath = "//input[@name='cusid']")
	private WebElement txt_CustId;

	@FindBy(xpath = "//input[@name='AccSubmit']")
	private WebElement btn_Submit;

	public WebElement getLink_DelCust() {
		return link_DelCust;
	}

	public WebElement getTxt_CustId() {
		return txt_CustId;
	}

	public WebElement getBtn_Submit() {
		return btn_Submit;
	}

	public DeleteCustPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void deleteCustPageOperations() {

		getLink_DelCust().click();
		sleep(3);

		getTxt_CustId().sendKeys("121203");
		sleep(3);

		getBtn_Submit().click();
		sleep(3);

		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		sleep(5);
		
		alert.accept();
		
		sleep(5);
		
		/*driver.switchTo().defaultContent();
		sleep(3);*/

	}

}
