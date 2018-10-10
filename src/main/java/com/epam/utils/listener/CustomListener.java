package com.epam.utils.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {
    private static final Logger log = Logger.getLogger(CustomListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("Test starts" + iTestResult.getMethod());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test is succesfull" + iTestResult.getMethod());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Test failed" + iTestResult.getMethod());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("Test skipped" + iTestResult.getMethod());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("Starting" + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("Finishing" + iTestContext.getName());
    }
}
