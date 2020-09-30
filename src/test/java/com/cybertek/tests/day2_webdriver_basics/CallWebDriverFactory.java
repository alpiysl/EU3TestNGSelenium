package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.linkText("Sign Up")).click();

        String title = driver.getTitle();
        System.out.println("title = " + title);



    }
}

