package listeners;

import base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        //System.out.println("Test failed :" + result.getName());
        BaseTest testInstance = (BaseTest) result.getInstance();
        WebDriver driver = testInstance.getDriver();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);

        Path destination = Paths.get("screenshootSelenium", result.getName() + ".png");
        try {
            Files.createDirectories(destination.getParent());
            Files.copy(src.toPath(), destination.toAbsolutePath());
        }catch (IOException e){
            System.out.println("IOException");
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }


}
