package com.cybertek.tests.day7_testng;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FirstTestNGTest {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");

        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("abc");
        String qw = q.getAttribute("value");
        System.out.println("qw = " + qw);


    }

    @Test
    public void test2(){
        System.out.println("Test case 2");
    }
}
