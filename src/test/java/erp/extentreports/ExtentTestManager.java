package erp.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import erp.base.BaseSetup;
import erp.common.helpers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.sound.midi.Synthesizer;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentManager.getExtentReports();

    public static ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest saveTestReport(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description).assignAuthor("Nhan Nguyen").assignCategory("Regression Test").assignDevice("Desktop");
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }

    public static void addScreenShot(String message) {

        String base64Image = "data:image/png;base64,"
                + (((TakesScreenshot) BaseSetup.getDriver()).getScreenshotAs(OutputType.BASE64));
        getTest().log(Status.INFO, message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }

    public static void addScreenShot(Status status, String message) {
        String base64Image = "data:image/png;base64,"
                + (((TakesScreenshot)BaseSetup.getDriver()).getScreenshotAs(OutputType.BASE64));

        getTest().log(status, message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }

    public static void logMessage(String message) {
        getTest().log(Status.INFO, message);
    }

    public static void logMessage(Status status, String message) {
        getTest().log(status, message);
    }
}
