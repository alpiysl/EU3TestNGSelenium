package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {
        //Verify confirmation message
            //open chrome browser
            //go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
            //enter any email
            //verify that email is displayed in the input box
            //click on Retrieve password
            //verify that confirmation message says ‘Your e-mail’s been sent!’

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInput = driver.findElement(By.name("email"));

        String expectedEmail = "mike@cybertek.com";
        emailInput.sendKeys(expectedEmail);

        String actualEmail = emailInput.getAttribute("value");

        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");

        }

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        WebElement confMes = driver.findElement(By.name("confirmation_message"));
        System.out.println(confMes.getText());


        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confMes.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }

        driver.quit();

    }
}
