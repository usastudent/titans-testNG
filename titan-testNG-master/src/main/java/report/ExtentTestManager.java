package report;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
	static ExtentReports extent = ExtentReportManager.createExtentReports();

	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int) Thread.currentThread().getId());
	}

	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.createTest(testName, desc);
		extentTestMap.put((int) Thread.currentThread().getId(), test);
		return test;
	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static ExtentTest getExtentTest() {
		 System.out.println("ExtentTestManager class: " + extentTest.get());
		return extentTest.get();
	}

	public static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	public static void unload() {
		extentTest.remove();
	}
}
