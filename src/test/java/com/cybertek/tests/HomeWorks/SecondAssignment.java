package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SecondAssignment {


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
    public void case1(){

        //go to webpage
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //find registration form and click
        WebElement registerFrom = driver.findElement(By.linkText("Registration Form"));
        registerFrom.click();

        //locate birthday box and sendKeys
        WebElement birthDayBox = driver.findElement(By.name("birthday"));
        birthDayBox.sendKeys("wrong_dob");

        //locate error message
        WebElement errorM = driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));

        //verify is the error message is displayed
        Assert.assertTrue(errorM.isDisplayed());
    }

    @Test
    public void case2(){
        //go to webpage
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //find registration form and click
        WebElement registerFrom = driver.findElement(By.linkText("Registration Form"));
        registerFrom.click();

        //locate checkBoxes
        WebElement cPlus = driver.findElement(By.xpath("//*[.='C++']"));
        WebElement Java = driver.findElement(By.xpath("//*[.='Java']"));
        WebElement JavaS = driver.findElement(By.xpath("//*[.='JavaScript']"));

        Assert.assertTrue(cPlus.isDisplayed(),"check c++ box");
        Assert.assertTrue(Java.isDisplayed(),"check Java box");
        Assert.assertTrue(JavaS.isDisplayed(),"check JavaScript box");

    }
    @Test
    public void case3(){
        //go to webpage
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //find registration form and click
        WebElement registerFrom = driver.findElement(By.linkText("Registration Form"));
        registerFrom.click();

        //locate firstName
        WebElement firstName = driver.findElement(By.name("firstname"));

        //send an alphabetic input
        String ch = "A";
        firstName.sendKeys(ch);

        //check the error is displayed
        WebElement errorM = driver.findElement(By.xpath("//*[@*='firstname'][1]"));
        Assert.assertTrue(errorM.isDisplayed());

    }

    @Test
    public void case4(){

        //go to webpage
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //find registration form and click
        WebElement registerFrom = driver.findElement(By.linkText("Registration Form"));
        registerFrom.click();

        //locate firstName
        WebElement firstName = driver.findElement(By.name("lastname"));

        //send an alphabetic input
        String ch = "A";
        firstName.sendKeys(ch);

        //check the error is displayed
        WebElement errorM = driver.findElement(By.xpath("//small[@*='lastname'][2]"));
        Assert.assertTrue(errorM.isDisplayed());

    }

    @Test
    public void case5(){
        //go to webpage
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //find registration form and click
        WebElement registerFrom = driver.findElement(By.linkText("Registration Form"));
        registerFrom.click();

        //locate firstName
        WebElement firstName = driver.findElement(By.name("firstname"));

        //send valid name
        firstName.sendKeys("Alpaslan");

        //locate lastname and send valid last name
        driver.findElement(By.name("lastname")).sendKeys("Uysal");

        //locate username and send valid username
        driver.findElement(By.name("username")).sendKeys("alpiia");

        //locate email send valid email
        driver.findElement(By.name("email")).sendKeys("alpi@alpi.com");

        //locate password and send a password
        driver.findElement(By.name("password")).sendKeys("122asd12");

        //locate phoneNumber and send a number
        driver.findElement(By.name("phone")).sendKeys("033-333-3312");

        //locate birthday and send valid birthday
        driver.findElement(By.name("birthday")).sendKeys("12/01/1989");

        //locate  Male radioButton and click
        driver.findElement(By.cssSelector("[value='male']")).click();

        //locate department dropdown
        WebElement department = driver.findElement(By.name("department"));

        //Select an option from Department dropdown
        Select opt = new Select(department);
        opt.selectByValue("DE");

        //locate jobTitle dropdown
        WebElement jT= driver.findElement(By.name("job_title"));

        //Select an option from Job title dropdown
        Select jOpt = new Select(jT);
        jOpt.selectByIndex(4);

        //locate programming language option and select
        driver.findElement(By.xpath("//*[.='Java']")).click();

        //locate submit button and click
        driver.findElement(By.cssSelector("#wooden_spoon")).click();

        //locate text and check is displayed or not
        WebElement text = driver.findElement(By.xpath("//p"));
        String expected = "You've successfully completed registration!";
        String actual = text.getText();

        Assert.assertEquals(actual,expected,"check the actual");

    }

    @Test
    public void case6() throws InterruptedException {

        driver.get("https://www.tempmailaddress.com/");
        WebElement fakeEmail = driver.findElement(By.cssSelector("#email"));
        String emailText = fakeEmail.getText();
        //open a new tab on browser
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND +"t");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Alpaslan");
        driver.findElement(By.name("email")).sendKeys(emailText);
        driver.findElement(By.name("wooden_spoon")).click();
        WebElement text = driver.findElement(By.xpath("//*[@*='subheader']"));
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = text.getText();
        Assert.assertEquals(actual,expected);
        driver.navigate().to("https://www.fakemail.net/");

       Thread.sleep(10000);
        WebElement doNot = driver.findElement(By.xpath("//*[@*='schranka']//tr[1]//td[1]"));
        String expectedEmail = " do-not-reply@practice.cybertekschool.com";
        String actualEmail = doNot.getText();
        Assert.assertEquals(actualEmail,expectedEmail);
        driver.findElement(By.xpath("//*[@*='schranka']//tr[1]//td[1]")).click();
        WebElement sbj = driver.findElement(By.cssSelector("#predmet"));
        String exp = "Thanks for subscribing to practice.cybertekschool.com!";
        String act = sbj.getText();
        Assert.assertEquals(act,exp);

    }

    @Test
    public void case7(){

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("File Upload")).click();
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/alpi/Desktop/file.txt");
        driver.findElement(By.cssSelector("#file-submit")).click();
        String expected = "File Uploaded!";
        String actual = driver.findElement(By.xpath("//*[.='File Uploaded!']")).getText();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void case8(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.cssSelector("#myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector(".btn.btn")).click();
        WebElement text = driver.findElement(By.cssSelector("#result"));
        String actual = text.getText();
        String expected = "You selected: United States of America";
        Assert.assertEquals(actual,expected);

    }

    @Test(dataProvider ="replyData")
    public void case9(String data , String data2) throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText(data)).click();
        driver.findElement(By.linkText(data2)).click();
        WebElement act = driver.findElement(By.xpath("//div[@id='content']//p"));
        String actual = act.getText();
        String[] actual1 = actual.split(". For");
        //System.out.println(Arrays.toString(actual1));
        String expected = actual1[0];
        //System.out.println(expected);
        Assert.assertTrue(actual1[0].contains(expected));


    }
    @DataProvider(name = "replyData")
    public Object[][] getData() {

        Object[][] data = new Object[4][2];
        data[0][0] = "Status Codes";
        data[0][1] = "200";

        data[1][0] = "Status Codes";
        data[1][1] = "301";

        data[2][0] = "Status Codes";
        data[2][1] = "404";

        data[3][0] = "Status Codes";
        data[3][1] = "500";


        return data;
    }

}
