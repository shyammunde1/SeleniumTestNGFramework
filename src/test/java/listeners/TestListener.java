package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;

public class TestListener implements ITestListener {

    private static final ExtentReports extentReports = ExtentReportManager
            .getReportInstance();
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getTestClass()
                .getRealClass()
                .getSimpleName()
                + " - "
                + result.getMethod().getMethodName();
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(
                Status.PASS, "Test Passed Successfully"
        );
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        Throwable throwable = result.getThrowable();
        extentTest.get().log(Status.FAIL, "Test Failed");

        if (throwable != null) {
            extentTest.get().fail(throwable);

        }
        BaseTest testInstance = (BaseTest) result.getInstance();
        WebDriver driver = testInstance.getDriver();


        if (driver != null) {

            TakesScreenshot screenshot = (TakesScreenshot) driver;

            String base64Screenshot =
                    screenshot.getScreenshotAs(OutputType.BASE64);

            extentTest.get().addScreenCaptureFromBase64String(
                    base64Screenshot
            );

        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(
                Status.SKIP,
                "Test Skipped"
        );
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();

    }


}
