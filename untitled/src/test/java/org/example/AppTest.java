package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest

{
    @Test
    public void test () {
        WebDriver  driver = new ChromeDriver();
        driver.manage().window().maximize();
     driver.get("https://www.facebook.com/");

    }

}
