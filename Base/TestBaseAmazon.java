package com.Amazon.qa.Base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBaseAmazon {
	
	public static WebDriver driver;
	public static ExtentReports extentreports;
	public static ExtentTest extentTest;
	
public void openBrowser(String Browser) {
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
}

@BeforeTest
public void getNamemethod(ITestContext context) {
	
	extentTest = extentreports.createTest(context.getName());
}

@BeforeSuite
public void InitializeExtentReport() {
	
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Amazon_user_report.html");
	extentreports= new ExtentReports();
	extentreports.attachReporter(sparkreporter);
	
	extentreports.setSystemInfo("OS",System.getProperty("os.name"));
	extentreports.setSystemInfo("java", System.getProperty("Java.version"));
}

@AfterSuite
public void generateReports() throws IOException {
	
	extentreports.flush();
	Desktop.getDesktop().browse(new File("Amazon_user_report.html").toURI());
	
}

@AfterMethod
public void generateTestStatus(Method m, ITestResult result) {
	if (result.getStatus() == ITestResult.FAILURE) {
		System.out.println("Capture Screenshot");
		extentTest.fail(result.getThrowable());
	} else if (result.getStatus() == ITestResult.SUCCESS) {
		extentTest.pass(m.getName() + " is passed");
	}
}

}
