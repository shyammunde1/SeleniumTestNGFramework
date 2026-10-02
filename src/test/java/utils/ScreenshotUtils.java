package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
        File screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        Path screenshotPath = Paths.get("screenshots", testName + ".png");
        Files.createDirectories(screenshotPath.getParent());
        Files.copy(screenshot.toPath(), screenshotPath, StandardCopyOption.REPLACE_EXISTING);
        return screenshotPath.toString();

    }
}
