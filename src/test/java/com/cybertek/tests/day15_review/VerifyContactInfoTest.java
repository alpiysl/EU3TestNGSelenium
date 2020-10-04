package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {

    @Test
    public void contactDetailsTest(){
        extentTest= report.createTest("TestCase About Verfying Email-phone-Username");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        loginPage.login(username,password);
        extentTest.info("login as sales manager");
        new DashboardPage().navigateToModule("Customer","Contacts");
        extentTest.info("navigate to contacts module from customers tab");
        ContactPage contactsPage = new ContactPage();

        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("demo.O@maildemo.com").click();
        extentTest.info("click on defined email");
        ContactInfoPage contactInfoPage = new ContactInfoPage();

        Assert.assertEquals(contactInfoPage.fullName.getText(),"Demo Omed");
        extentTest.info("verify that user name is Demo Omed");
        Assert.assertEquals(contactInfoPage.phone.getText(),"1234567890");
        extentTest.info("verify phone number");
        Assert.assertEquals(contactInfoPage.email.getText(),"demo.O@maildemo.com");
        extentTest.info("verify email");

        extentTest.pass("pass");

    }

}
