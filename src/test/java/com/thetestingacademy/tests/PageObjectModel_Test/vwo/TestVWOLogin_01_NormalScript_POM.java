package com.thetestingacademy.tests.PageObjectModel_Test.vwo;

import com.thetestingacademy.pages.PageObjectModel.vwo.normal_POM.DashboardPage;
import com.thetestingacademy.pages.PageObjectModel.vwo.normal_POM.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_01_NormalScript_POM {

    @Owner("Bhagya")
    @Description("verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login(){
        //Driver Manager Code - 1
        WebDriver driver = new ChromeDriver();

        //Page Class Code(POM code) - 2
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCreds("admin@gmail.com","1234");

        //Assertions - 3
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");
        driver.quit();
    }

    @Owner("Bhagya")
    @Description("TC02 - verify that with valid credentials dashboard is loaded")
    @Test
    public void testLoginPositiveVWO(){
        //Driver Manager Code - 1
        WebDriver driver = new ChromeDriver();

        //Page Class Code(POM code) - 2
        LoginPage loginPage_vwo = new LoginPage(driver);
        loginPage_vwo.loginToVWOLoginValidCreds("hebiva4776@amcret.com","Test@4321");

        DashboardPage dashboardPage = new DashboardPage(driver);
        String usernameLoggedIn = dashboardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotEmpty().isNotBlank().isNotNull();
        Assert.assertEquals(usernameLoggedIn,"Amcret");

        driver.quit();

    }
}
