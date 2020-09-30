package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGassertionDemo {

    @BeforeMethod
    public void setUp() {
        System.out.println("Open Browser");
    }

    @Test
    public void test1(){
        System.out.println("first assert");
        Assert.assertEquals("title","tiTle");

        Assert.assertEquals("url","url");
        System.out.println("second assert");
    }

    @Test
    public void test2(){
        String expectedTitle ="Cyt";
        String actualTitle = "Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"verify title starts with Cyb");
    }

    @Test
    public void test3(){
        //verify email contains @ sign
        String email = "mikesmith.com";
        Assert.assertTrue(email.contains("@"),"verify email contains @");

    }

    @Test
    public void test5(){
        Assert.assertFalse(0>1,"verify that 0 is not greater than 1");

    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
    }
}
