package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;
import utils.ScreenshotUtils;

import java.io.IOException;

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
        try {
            extentTest.get().log(
                    Status.PASS, "Test Passed Successfully"
            );
            ITestListener.super.onTestSuccess(result);
        } finally {
            extentTest.remove();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ITestListener.super.onTestFailure(result);

            Throwable throwable = result.getThrowable();

            extentTest.get().log(Status.FAIL, "Test Failed");

            if (throwable != null) {
                extentTest.get().fail(throwable);
            }

            WebDriver driver = null;

            if (result.getInstance() instanceof BaseTest testInstance) {
                driver = testInstance.getDriver();
            }

            String testName = result.getMethod().getMethodName();

            if (driver != null) {
                try {
                    String screenShotPath =
                            ScreenshotUtils.captureScreenshot(driver, testName);

                    extentTest.get().addScreenCaptureFromPath(screenShotPath);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } finally {
            extentTest.remove();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            extentTest.get().log(
                    Status.SKIP,
                    "Test Skipped"
            );

            ITestListener.super.onTestSkipped(result);

        } finally {
            extentTest.remove();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();

    }


}
