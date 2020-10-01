package com.cybertek.tests.day14_extetnt_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.BeforeMethod;

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
}
