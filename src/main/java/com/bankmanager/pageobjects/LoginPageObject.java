package com.bankmanager.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankmanager.testbase.TestBase;

public class LoginPageObject extends TestBase {

	@FindBy(xpath = "//input[@name='uid']")
	private WebElement txt_UserId;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txt_PassWord;

	@FindBy(xpath = "//input[@name='btnLogin']")
	private WebElement btn_Login;

	public WebElement getTxt_UserId() {
		return txt_UserId;
	}

	public void setTxt_UserId(WebElement txt_UserId) {
		this.txt_UserId = txt_UserId;
	}

	public WebElement getTxt_PassWord() {
		return txt_PassWord;
	}

	public void setTxt_PassWord(WebElement txt_PassWord) {
		this.txt_PassWord = txt_PassWord;
	}

	public WebElement getBtn_Login() {
		return btn_Login;
	}

	public void setBtn_Login(WebElement btn_Login) {
		this.btn_Login = btn_Login;
	}
	
	public LoginPageObject(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void loginPageOperations(String userID, String password) {

		System.out.println("Please Enter the below Credentials for Login");
		getTxt_UserId().sendKeys(userID);
		getTxt_PassWord().sendKeys(password);

		System.out.println("Please click on below Login Button to get Logged In");
		getBtn_Login().click();

	}

}
