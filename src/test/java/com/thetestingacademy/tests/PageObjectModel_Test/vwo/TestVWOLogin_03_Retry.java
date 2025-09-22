package com.thetestingacademy.tests.PageObjectModel_Test.vwo;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.listeners.RetryAnalyzer;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.devtools.v137.page.model.Screenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManager.getDriver;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_03_Retry extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_03_Retry.class);

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Allure.addAttachment("Log output", "text/plain", "This is some log text");
        Assert.assertTrue(false);
    }

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(true);
    }

}
