package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class exercise {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.facebook.com/");

        WebElement emailinp = driver.findElement(By.name("email"));

        emailinp.sendKeys("alp_5191@hotmail.com");

        WebElement pass = driver.findElement(By.name("pass"));

        pass.sendKeys("assdf");

        WebElement button = driver.findElement(By.name("login"));
        button.click();



    }
}
