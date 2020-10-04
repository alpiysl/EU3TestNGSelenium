package com.cybertek.tests.day14_extetnt_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){
        extentTest = report.createTest("Wrong Password Test");
        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentTest.info("Enter user name");
        loginPage.passwordInput.sendKeys("somepassword");
        extentTest.info("Enter wrong password");
        loginPage.loginBtn.click();
        extentTest.info("click login button");


        extentTest.info("verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentTest.pass("Wrong password Test is Passed");

    }

    @Test
    public void wrongUsernameTest(){

        extentTest = report.createTest("Wrong user name");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        extentTest.info("write wrong username");
        loginPage.passwordInput.sendKeys("UserUser123");
        extentTest.info("write correct password");
        loginPage.loginBtn.click();

        extentTest.info("verify the url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/loginasd");

        extentTest.pass("test passed");

    }

}
