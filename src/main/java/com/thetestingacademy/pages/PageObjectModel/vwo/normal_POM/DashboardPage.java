package com.thetestingacademy.pages.PageObjectModel.vwo.normal_POM;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameOnDashboard = By.xpath("//h6");
    //Page Actions
    public  String loggedInUserName(){
        WaitHelpers.waitJVM(1000);
        driver.get("https://app.vwo.com/#/dashboard");
        return driver.findElement(userNameOnDashboard).getText();
    }
}
