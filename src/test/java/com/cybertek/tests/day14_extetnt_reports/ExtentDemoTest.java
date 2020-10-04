package com.cybertek.tests.day14_extetnt_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    //this class is used for starting and building reports
    ExtentReports reports;

    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //this will define a test, enables adding logs,authors, test steps
    ExtentTest extentTest;

    @BeforeMethod
    public void setup(){
        //initialize the class
        reports = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        reports.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        reports.setSystemInfo("Environment","QA");
        reports.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        reports.setSystemInfo("OS",System.getProperty("os.name"));

    }

    @Test
    public void test1(){

        //give name to current
        extentTest = reports.createTest("TC1 Login as Driver Test");

        //test steps
        extentTest.info("Open chrome");
        extentTest.info("Go to this URL");
        extentTest.info("Enter username and password");
        extentTest.info("click login");
        extentTest.info("Verify logged in");

        //pass()-> marks the test as passed
        extentTest.pass("TC1 is passed");

    }

    @AfterMethod
    public void td(){
        reports.flush();
    }

}
