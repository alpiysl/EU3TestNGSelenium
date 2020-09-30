package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/upload");
        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));

        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String filePath = "src/test/resources/textfile.txt";
        String fullPath = projectPath + "/" + filePath;

        chooseFile.sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        String actualResult=driver.findElement(By.xpath("//*[text()='File Uploaded!']")).getText();
        String expectedResult="File Uploaded!";
        Assert.assertEquals(actualResult,expectedResult);

    }
}
