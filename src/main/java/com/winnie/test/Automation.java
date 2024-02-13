package com.winnie.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://youtube.com");
    }
}
