package com.cybertek.tests.day5_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    public static void main(String[] args) throws InterruptedException {
        //open chrome and go to amazon webpage
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        //find searchbox and send selenium word
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("selenium");

        //click search button
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Go']"));
        submitButton.click();

        //find result in number
        WebElement searchResultInNumber = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        String numberResult = searchResultInNumber.getText();
        System.out.println(numberResult);


        //find searched word written after result in number
        WebElement searchedWord = driver.findElement(By.xpath("//h1//span[starts-with(@dir,'auto')][3]"));
        String Word = searchedWord.getText();

        //expected results
        String expected1 ="1-48 of 164 results for \"selenium\"";
        String expected2 ="1-48 of 166 results for \"selenium\"";
        String expected3 ="1-48 of 171 results for \"selenium\"";

        //actual result
        String actual = numberResult +" "+ Word;


        Thread.sleep(3000);
        driver.quit();

        //actual vs expected
        if(actual.equalsIgnoreCase(expected1) || actual.equalsIgnoreCase(expected2) || actual.equalsIgnoreCase(expected3)){
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }
    }
}
