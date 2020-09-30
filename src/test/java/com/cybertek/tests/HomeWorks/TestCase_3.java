package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_3 {

    public static void main(String[] args) {
        //go to Wikipedia
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        //find searchBox and Enter selenium webdriver
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchInput']"));
        searchBox.sendKeys("selenium webdriver");

        //find searchButton and click
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='searchButton']"));
        searchButton.click();

        //verify title contains selenium
        String title = driver.getTitle();

        String expected = "Selenium";
        if(title.contains(expected.toLowerCase())){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }

        driver.quit();


    }
}
