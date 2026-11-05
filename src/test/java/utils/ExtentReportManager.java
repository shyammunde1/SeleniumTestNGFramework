package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {

    private static ExtentReports extentReports;

    private ExtentReportManager() {
        // Prevent object creation from outside this class
    }

    public static synchronized ExtentReports getReportInstance() {

        if (extentReports == null) {

            ExtentSparkReporter extentSparkReporter =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
        }

        return extentReports;
    }
}
