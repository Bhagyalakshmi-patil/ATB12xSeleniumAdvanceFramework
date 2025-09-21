package com.thetestingacademy.tests.sample;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseBoilerPlate {
    public ChromeDriver driver;

    @BeforeTest
    public void openBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        driver.get("https://app.vwo.com");
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
    }
    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
