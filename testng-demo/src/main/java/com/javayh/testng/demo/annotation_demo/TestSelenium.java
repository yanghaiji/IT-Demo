package com.javayh.testng.demo.annotation_demo;

import org.testng.annotations.Test;

@Test(groups = "selenium-test")
public class TestSelenium {

    public void runSelenium() {
        System.out.println("runSelenium()");
    }

    public void runSelenium1() {
        System.out.println("runSelenium()1");
    }

}