package erp.base;

import com.aventstack.extentreports.Status;
import erp.extentreports.ExtentTestManager;

import static erp.extentreports.ExtentManager.getExtentReports;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ulitilities.Log;

import java.io.ByteArrayInputStream;

public class ReportListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        System.out.println("End: " + arg0.getName());
        getExtentReports().flush();

    }

    @Override
    public void onStart(ITestContext arg0) {
        System.out.println("Start: " + arg0.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("a " + arg0.getName());

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        System.out.println("test case failed: " + arg0.getName());
        ExtentTestManager.logMessage(Status.FAIL, arg0.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, arg0.getName() + " is failed.");
        ExtentTestManager.addScreenShot(Status.FAIL, arg0.getName() + " is failed.");
        Log.error("Failed: " + arg0.getName());
        Log.error(arg0.getThrowable().toString() +"\n");
        ExtentTestManager.addScreenShot(Status.FAIL,arg0.getName() +" Failed");

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub
        ExtentTestManager.logMessage(Status.SKIP, arg0.getThrowable().toString());
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("Start with Test name: " + arg0.getName());
        ExtentTestManager.saveTestReport(arg0.getName(), arg0.getTestName());

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("End test name: " + arg0.getName());
        ExtentTestManager.logMessage(Status.PASS, arg0.getName() + " is passed.");
    }

}
