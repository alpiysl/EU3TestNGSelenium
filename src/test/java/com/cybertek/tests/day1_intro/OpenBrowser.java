package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.IOException;

public class OpenBrowser {

    public static void main(String[] args) throws IOException {

        //we have to enter this line every time we want to open chrome
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://cybertekschool.com");



        WebDriverManager.chromedriver().setup();

        WebDriver driver2 = new ChromeDriver();

        driver2.get("https://cybertekschool.com");

    }
}
