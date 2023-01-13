package com.bankmanager.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bankmanager.pageobjects.EditCustPageObject;
import com.bankmanager.pageobjects.LoginPageObject;
import com.bankmanager.pageobjects.NewCustomerPageObjects;
import com.bankmanager.testbase.TestBase;

public class TC003_VerifyEditCustPage extends TestBase {

	@Test
	public void verifyEditCustPageTest() {

		LoginPageObject obj = new LoginPageObject(driver);

		obj.loginPageOperations(getData("userID"), getData("password"));

		NewCustomerPageObjects obj1 = new NewCustomerPageObjects(driver);
		obj1.newCustPageOperations();

		EditCustPageObject obj3 = new EditCustPageObject(driver);
		obj3.editCustPageOperations();

	}

	@BeforeMethod
	public void testStart() {
		launchBrowser(getData("browser"));
		selectUrl(getData("url"));

	}

}
