package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

public class Section1 {


    @Test
    public void test1() throws InterruptedException {
        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //maximize the window
        driver.manage().window().maximize();

        //open the seleniumeasy webpage
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //find checkbox element
        WebElement checkBox = driver.findElement(By.cssSelector("div#txtAge"));

        //verify message is NOT displayed and not selected
        Assert.assertFalse(checkBox.isSelected());
        System.out.println("checkBox.isSelected() = " + checkBox.isSelected());
        Assert.assertFalse(checkBox.isDisplayed(),"verify Success-Check box is checked is NOT displayed");
        System.out.println("checkBox.isDisplayed() = " + checkBox.isDisplayed());

        //find the checkbox click the
        WebElement clickBox = driver.findElement(By.cssSelector("input#isAgeSelected"));
        clickBox.click();

        //verify message is Displayed
        checkBox= driver.findElement(By.cssSelector("div#txtAge"));
        Assert.assertTrue(checkBox.isDisplayed(),"verify Success-Check box is checked IS  displayed");
        System.out.println("checkBox.isDisplayed() = " + checkBox.isDisplayed());

        Thread.sleep(3000);

        driver.quit();
    }



}
