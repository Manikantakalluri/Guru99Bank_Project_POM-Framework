package com.bankmanager.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bankmanager.pageobjects.DeleteCustPageObject;
import com.bankmanager.pageobjects.EditAccountPageObject;
import com.bankmanager.pageobjects.EditCustPageObject;
import com.bankmanager.pageobjects.LoginPageObject;
import com.bankmanager.pageobjects.NewAccountPageObject;
import com.bankmanager.pageobjects.NewCustomerPageObjects;
import com.bankmanager.testbase.TestBase;

public class TC006_VerifyEditAccPage extends TestBase {

	@Test
	public void newAccountPageTest() {

		LoginPageObject obj = new LoginPageObject(driver);

		obj.loginPageOperations(getData("userID"), getData("password"));

		NewCustomerPageObjects obj1 = new NewCustomerPageObjects(driver);
		obj1.newCustPageOperations();

		EditCustPageObject obj3 = new EditCustPageObject(driver);
		obj3.editCustPageOperations();

		DeleteCustPageObject obj4 = new DeleteCustPageObject(driver);
		obj4.deleteCustPageOperations();

		NewAccountPageObject obj5 = new NewAccountPageObject(driver);
		obj5.newAccPageOperations();

		EditAccountPageObject obj6 = new EditAccountPageObject(driver);
		obj6.editAccPageOperations();
	}

	@BeforeMethod
	public void testStart() {
		launchBrowser(getData("browser"));
		selectUrl(getData("url"));

	}
}
