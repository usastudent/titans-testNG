package report;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import common.BaseTest;
import enums.AuthorType;
import enums.CategoryType;

public class ExtentReportManager {

	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("TEK School Sample TestNG Framework - Extent");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Blog Name", "SW Test Academy");
		extentReports.setSystemInfo("Author", "Onur Baskirt");

		return extentReports;
	}

	public static ExtentTest createTest(String testCaseName, String description) {
		ExtentTest temp = extentReports.createTest(testCaseName, description);
		ExtentTestManager.setExtentTest(temp);
		return temp;
	}

	public static void removeTest(String testCaseName) {
		extentReports.removeTest(testCaseName);
	}

//	public static void addScreenShot(String message) {
//
//		extentReports.createTest("ScreenCapture").addScreenCaptureFromPath("extent.png")
//				.pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());
//
////		String base64Image = "data:image/png;base64,"
////				+ ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BASE64);
////		ExtentTestManager.getExtentTest().log(Status.INFO, message, ExtentTestManager.getExtentTest()
////				.addScreenCaptureFromBase64String(base64Image).getModel().getMedia().get(0));
//	}

	public static void addScreenShot(Status status, String message) {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BASE64);

		ExtentTestManager.getExtentTest().log(status, message, ExtentTestManager.getExtentTest()
				.addScreenCaptureFromBase64String(base64Image).getModel().getMedia().get(0));
	}

	synchronized public static void addAuthors(AuthorType[] authors) {
		if (authors == null) {
			ExtentTestManager.getExtentTest().assignAuthor("TESTER");
		} else {
			for (AuthorType author : authors) {
				ExtentTestManager.getExtentTest().assignAuthor(author.toString());
			}
		}
	}

	synchronized public static void addCategories(CategoryType[] categories) {
		if (categories == null) {
			ExtentTestManager.getExtentTest().assignCategory("REGRESSION");
		} else {
			// for (String category : categories) {
			for (CategoryType category : categories) {
				ExtentTestManager.getExtentTest().assignCategory(category.toString());
			}
		}
	}

	public static void logMessage(String message) {
		ExtentTestManager.getExtentTest().log(Status.INFO, message);
	}

	public static void logMessage(Status status, String message) {
		ExtentTestManager.getExtentTest().log(status, message);
	}

	public static void logMessage(Status status, Object message) {
		ExtentTestManager.getExtentTest().log(status, (Throwable) message);
	}

	public static void pass(String message) {
		// System.out.println("ExtentReportManager class: " +
		// ExtentTestManager.getExtentTest());
		ExtentTestManager.getExtentTest().pass(message);
	}

	public static void pass(Markup message) {
		ExtentTestManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentTestManager.getExtentTest().fail(message);
	}

	public static void fail(Object message) {
		ExtentTestManager.getExtentTest().fail((String) message);
	}

	public static void fail(Markup message) {
		ExtentTestManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentTestManager.getExtentTest().skip(message);
	}

	public static void skip(Markup message) {
		ExtentTestManager.getExtentTest().skip(message);
	}

	public static void info(Markup message) {
		ExtentTestManager.getExtentTest().info(message);
	}

	public static void info(String message) {
		ExtentTestManager.getExtentTest().info(message);
	}

	public static void warning(String message) {
		ExtentTestManager.getExtentTest().log(Status.WARNING, message);
	}

}
