package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Section2 {

    @Test
    public void test() throws InterruptedException {
        //open firefox browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //open the seleniumeasy webpage
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //find checkAll button
        WebElement checkAll = driver.findElement(By.cssSelector(".btn.btn-primary"));

        //check the text
        String check_all = checkAll.getAttribute("value");

        //verify checkAll button
        System.out.println(check_all);
        Assert.assertTrue(check_all.contains("Check All"));

        //click checkAll button
        checkAll.click();
        Thread.sleep(2000);

        //verify all check boxes are checked
        WebElement option1 = driver.findElement(By.xpath("//label[text()='Option 1']/input"));
        Assert.assertTrue(option1.isSelected(),"option 1 control");
        WebElement option2 = driver.findElement(By.xpath("//label[text()='Option 2']/input"));
        Assert.assertTrue(option2.isSelected(),"option 2 control");
        WebElement option3 = driver.findElement(By.xpath("//label[text()='Option 3']/input"));
        Assert.assertTrue(option3.isSelected(),"option 3 control");
        WebElement option4 = driver.findElement(By.xpath("//label[text()='Option 4']/input"));
        Assert.assertTrue(option4.isSelected(),"option 4 control");



        //verif check All button changed to Uncheck All
        check_all = checkAll.getAttribute("value");
        System.out.println(check_all);
        Assert.assertTrue(check_all.contains("Uncheck All"));

        driver.quit();


    }
}
