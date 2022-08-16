package listeners;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.BaseTest;
import report.ExtentReportManager;
import report.ExtentTestManager;
import utils.DriverUtility;
import utils.Log;

public class TestListener extends BaseTest implements ITestListener {

	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
//	private static String getTestMethodName(ITestResult iTestResult) {
//	System.out.println("get name");
//		return iTestResult.getMethod().getConstructorOrMethod().getName();
//	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test Execution Started");
		
		ExtentReportManager.createExtentReports();
		
		
		String methodName = result.getMethod().getMethodName();
		String qualifiedName = result.getMethod().getQualifiedName();
		int last = qualifiedName.lastIndexOf(".");
		int mid = qualifiedName.substring(0, last).lastIndexOf(".");
		String className = qualifiedName.substring(mid + 1, last);

		System.out.println(methodName + " started!");
		ExtentTest extentTest = ExtentReportManager.extentReports.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());

		extentTest.assignCategory(result.getTestContext().getSuite().getName());
		/*
		 * methodName = StringUtils.capitalize(StringUtils.join(StringUtils.
		 * splitByCharacterTypeCamelCase(methodName), StringUtils.SPACE));
		 */
		extentTest.assignCategory(className);
		test.set(extentTest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		logger.info("Test was passed successfully");
		logger.info("method name: " + result.getMethod().getMethodName());
		test.get().pass("Test passed");
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		logger.info("Test was failed");
		logger.info("method name: " + result.getMethod().getMethodName());
		DriverUtility.screenShot();
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
		// TODO Auto-generated method stub
		logger.info("method name: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		logger.info("method name: " + result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		logger.info("Start of Execution");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		logger.info("End of Execution");
		System.out.println(("Test Suite is ending!"));
		ExtentReportManager.extentReports.flush();
		test.remove();
	}
	
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
