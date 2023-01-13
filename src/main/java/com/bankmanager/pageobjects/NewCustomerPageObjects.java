package com.bankmanager.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankmanager.testbase.TestBase;

public class NewCustomerPageObjects extends TestBase {

	@FindBy(xpath = "//a[text()='New Customer']")
	private WebElement link_NewCustomer;

	public WebElement getLink_NewCustomer() {
		return link_NewCustomer;
	}

	@FindBy(xpath = "//input[@name='name']")
	private WebElement txt_CustName;

	@FindBy(xpath = "//input[@value='m']")
	private WebElement rbtn_Male;

	@FindBy(xpath = "//input[@value='f']")
	private WebElement rbtn_Female;

	@FindBy(id = "dob")
	private WebElement select_Dob;

	@FindBy(xpath = "//textarea[@name='addr']")
	private WebElement txt_Address;

	@FindBy(xpath = "//input[@name='city']")
	private WebElement txt_City;

	@FindBy(xpath = "//input[@name='state']")
	private WebElement txt_State;

	@FindBy(xpath = "//input[@name='pinno']")
	private WebElement txt_Pin;

	@FindBy(xpath = "//input[@name='telephoneno']")
	private WebElement txt_MobileNumber;

	@FindBy(xpath = "//input[@name='emailid']")
	private WebElement txt_EmailId;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txt_Password;

	public WebElement getTxt_CustName() {
		return txt_CustName;
	}

	public WebElement getRbtn_Male() {
		return rbtn_Male;
	}

	public WebElement getRbtn_Female() {
		return rbtn_Female;
	}

	public WebElement getSelect_Dob() {
		return select_Dob;
	}

	public WebElement getTxt_Address() {
		return txt_Address;
	}

	public WebElement getTxt_City() {
		return txt_City;
	}

	public WebElement getTxt_State() {
		return txt_State;
	}

	public WebElement getTxt_Pin() {
		return txt_Pin;
	}

	public WebElement getTxt_MobileNumber() {
		return txt_MobileNumber;
	}

	public WebElement getTxt_EmailId() {
		return txt_EmailId;
	}

	public WebElement getTxt_Password() {
		return txt_Password;
	}

	public WebElement getBtn_Submit() {
		return btn_Submit;
	}

	@FindBy(xpath = "//input[@name='sub']")
	private WebElement btn_Submit;

	public NewCustomerPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void newCustPageOperations() {

		getLink_NewCustomer().click();
		sleep(3);
		getTxt_CustName().sendKeys(getData("CustName"));
		sleep(3);
		getRbtn_Male().click();
		// getSelect_Dob().click();
		getTxt_Address().sendKeys("Flat No:401,Road No:27A,Sri Guru Sairam Enclave");
		getTxt_City().sendKeys("Miyapur");
		getTxt_State().sendKeys("Telangana");
		getTxt_Pin().sendKeys("502032");
		getTxt_MobileNumber().sendKeys("9032866804");
		getTxt_EmailId().sendKeys("Manikanta.Kalluri@gmail.com");
		getTxt_Password().sendKeys("Mani@123");
		getBtn_Submit().click();
		sleep(3);

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
