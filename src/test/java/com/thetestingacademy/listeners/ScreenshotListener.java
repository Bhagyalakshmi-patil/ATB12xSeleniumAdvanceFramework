package com.thetestingacademy.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        Object testClass = result.getInstance();

    }
}
