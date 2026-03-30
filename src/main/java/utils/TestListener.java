package utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.*;
import base.BaseTest;

public class TestListener extends TestListenerAdapter {

    static ExtentReports extent = ExtentManager.getInstance();
    static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        String path = ScreenshotUtils.captureScreenshot(BaseTest.driver, result.getName());

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}