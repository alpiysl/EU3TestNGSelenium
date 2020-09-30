package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_2 {

    public static void main(String[] args) {

        //TEST CASE 2
        //go to ebay
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("https://www.ebay.com/");

        //enter search item
        WebElement searchItem = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        String item = "selenium";
        searchItem.sendKeys(item);

        //click search button
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchButton.click();

        //verify Title
        WebElement verifyTitle = driver.findElement(By.xpath("//h1//span[starts-with(@class,'BOLD')][2]"));
        String ResultTitle = verifyTitle.getText();


        if(ResultTitle.equalsIgnoreCase(item)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();
    }
}
