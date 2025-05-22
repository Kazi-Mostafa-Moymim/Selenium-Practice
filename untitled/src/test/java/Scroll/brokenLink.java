package Scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLink { // Renamed class to follow Java conventions (PascalCase)

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe"); // Add ChromeDriver path
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void testBrokenLinks() throws Exception { // Moved code into a TestNG method
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)");

        SoftAssert softAssert = new SoftAssert();
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            softAssert.assertTrue(respCode < 400,
                    "Link with text '" + link.getText() + "' is broken. Response code: " + respCode);
        }
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); // Close the browser after the test
    }
}