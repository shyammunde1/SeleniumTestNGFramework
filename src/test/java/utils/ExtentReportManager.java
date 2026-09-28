package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getReportInstance() {
        ExtentSparkReporter extentSparkReporter = new
                ExtentSparkReporter("test-output/ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }
}
