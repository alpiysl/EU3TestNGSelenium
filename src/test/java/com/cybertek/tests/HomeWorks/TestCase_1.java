package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_1 {

    public static void main(String[] args) {
        //TEST CASE 1
        //go to ebay
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("https://www.ebay.com/");

        //enter search item
        WebElement searchItem = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchItem.sendKeys("headset");

        //click search button
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchButton.click();

        //NUmber of result
        WebElement resultNum = driver.findElement(By.xpath("//h1//span[starts-with(@class,'BOLD')][1]"));
        String text = resultNum.getText();
        System.out.println(text);

        driver.quit();




    }
}
