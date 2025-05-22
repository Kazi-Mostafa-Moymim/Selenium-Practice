package Scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class automationScroll {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor jr = (JavascriptExecutor) driver;
        jr.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        Thread.sleep(2000);
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
         int sum = 0;
        for(int i = 0;i<values.size();i++)
        {
          sum = sum + Integer.parseInt( values.get(i).getText());

        }
        System.out.println(sum);
        int s = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        System.out.println(s);
        Assert.assertEquals(sum,s);

        jr.executeScript(" window.scrollBy(0,5000)");

    }
}
