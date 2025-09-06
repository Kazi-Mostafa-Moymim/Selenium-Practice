package Scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.net.*;
import java.util.List;
   public class brokenLink {


    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor jr = (JavascriptExecutor) driver;
        jr.executeScript(" window.scrollBy(0,5000)");
        SoftAssert a = new SoftAssert();
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for(WebElement link :links)
        {
            String url = link.getAttribute("href");
            System.out.println(url);
            HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println("response code is " +respCode);
            a.assertTrue(respCode<400," the link with text " + link.getText() +  " is broken with response code" + respCode);


        }
        a.assertAll();

    }

}




