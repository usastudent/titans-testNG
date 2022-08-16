package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.BaseTest;
import report.ExtentReportManager;

public class NewTest extends BaseTest {

	@Test
	public void f() {
		System.out.println("before shot");
		System.out.println("after shot");

	}
	@Test
	public void fw() {
		System.out.println("before shot");
		System.out.println("after shot");
		
	}
	@Test
	public void fe() {
		System.out.println("before shot");
		System.out.println("after shot");
		
	}
	@Test
	public void fr() {
		System.out.println("before shot");
		System.out.println("after shot");
		
	}

	@BeforeMethod
	public void beforeMethod() {
		initializeDriver();
		logger.info("Hotel Page is opened");
		

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after");
		tearDown();
	}

}
