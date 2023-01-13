package com.bankmanager.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bankmanager.pageobjects.LoginPageObject;
import com.bankmanager.pageobjects.NewCustomerPageObjects;
import com.bankmanager.testbase.TestBase;

public class TC002_VerifyNewCustPage extends TestBase {

	@Test
	public void verifyNewCustPageOperations() {

		NewCustomerPageObjects obj1 = new NewCustomerPageObjects(driver);

		LoginPageObject obj = new LoginPageObject(driver);
		obj.loginPageOperations(getData("userID"), getData("password"));

		obj1.newCustPageOperations();
	}

	@BeforeMethod
	public void testStart() {
		launchBrowser(getData("browser"));
		selectUrl(getData("url"));

	}

}
