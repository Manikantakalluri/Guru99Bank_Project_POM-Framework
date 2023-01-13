package com.bankmanager.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bankmanager.pageobjects.LoginPageObject;
import com.bankmanager.testbase.TestBase;

public class TC001_VerifyLoginPage extends TestBase {

	@Test
	public void verifyLoginOperation() {
		System.out.println("*****************Login Page Test Started**********************");
		LoginPageObject obj = new LoginPageObject(driver);
		obj.loginPageOperations(getData("userID"), getData("password"));
		System.out.println("*****************Loging Page Test Finished ");

	}

	@BeforeMethod
	public void testStart() {
		launchBrowser(getData("browser"));
		selectUrl(getData("url"));

	}

}
