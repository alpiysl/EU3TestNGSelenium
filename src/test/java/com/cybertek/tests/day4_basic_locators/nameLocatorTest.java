package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.name("full_name"));

        fullName.sendKeys("Mike Smith");

        WebElement email = driver.findElement(By.name("email"));

        email.sendKeys("msmith@asd.com");

        //lazy way
        //driver.findElement(By.name("email")).sendKeys();

        WebElement clickB = driver.findElement(By.name("wooden_spoon"));

        clickB.click();

        //driver.findElement(By.name("wooden_spoon")).click();


    }
}
