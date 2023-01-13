package com.bankmanager.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Properties;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;

	public Properties OR = new Properties();

	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;

	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "\\src\\main\\java\\com\\bankmanager\\reports\\"
				+ formater.format(calendar.getTime()) + "_POMReports.html", false);
	}

	public void loadData() {
		try {
			String path = System.getProperty("user.dir") + "/src/main/java/com/bankmanager/config/config.properties";
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			OR.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getData(String property) {
		loadData();
		return OR.getProperty(property);

	}

	public void launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

	}

	public void selectUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void sleep(int sec) {

		try {
			Thread.sleep(1000 * sec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser() {
		driver.close();
		extent.endTest(test);
		extent.flush();
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		getresult(result);
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		closeBrowser();
	}

	public String captureScreenshot(String fileName) {

		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;

		String path = System.getProperty("user.dir");

		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");

		String text = formater.format(calendar.getTime());

		try {

			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			destFile = new File(path + "/src/main/java/com/bankmanager/screenshots/" + text + "image.jpg");

			FileUtils.copyFile(srcFile, destFile);

		} catch (Exception e) {
			System.out.println("Unable to take Screenshot");
		}
		return destFile.toString();
	}

	public void getresult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			String screen = captureScreenshot("LoginOperation");
			test.log(LogStatus.PASS, test.addScreenCapture(screen));
			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			String screen = captureScreenshot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}

}
