package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) {
    /*Verify URL changed
        open browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent
    */


        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //send keys-> action to the webelement
        emailInputBox.sendKeys("mike@cybertek.com");

        //save expected url before clicking button
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        //click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //save actual url after clicking button
        String actualUrl = driver.getCurrentUrl();

        //verify that url did not change
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        //close your browser
        driver.quit();
    }
}
