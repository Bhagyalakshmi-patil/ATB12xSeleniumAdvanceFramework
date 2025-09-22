package com.thetestingacademy.tests.PageObjectModel_Test.vwo;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.PageObjectModel.vwo.normal_POM.DashboardPage;
import com.thetestingacademy.pages.PageObjectModel.vwo.normal_POM.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_PropertyReader_DriverManager_POM_CommonToAll extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_02_PropertyReader_DriverManager_POM_CommonToAll.class);

    @Owner("Bhagya")
    @Description("verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login(){

        logger.info("Starting the Testcases Page Object Model");
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        //Assertions - 3
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));
    }
    @Owner("Bhagya")
    @Description("TC02 - verify that with valid credentials dashboard is loaded")
    @Test
    public void testLoginPositiveVWO(){

        logger.info("Starting the Testcases Page Object Model");
        LoginPage loginPage_vwo = new LoginPage(DriverManager.getDriver());
        loginPage_vwo.loginToVWOLoginValidCreds("hebiva4776@amcret.com","Test@4321");

        logger.info("Login Done, now moving to the dashboard!");

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashboardPage.loggedInUserName();

        logger.info("Username I got -> "+usernameLoggedIn);
        
        assertThat(usernameLoggedIn).isNotEmpty().isNotBlank().isNotNull();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));

    }

}
