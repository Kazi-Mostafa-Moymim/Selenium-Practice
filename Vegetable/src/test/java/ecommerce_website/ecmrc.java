package ecommerce_website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ecmrc {
    @Test
    public void mainPage() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("auntu789@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("1314404499");
        driver.findElement(By.id("login")).click();
        List<WebElement> products = driver.findElements(By.className("mb-3"));
        WebElement prod = products.stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("zara coat 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        List<WebElement> cards = driver.findElements(By.cssSelector(".cart h3"));
        Boolean match = cards.stream().anyMatch(card -> card.getText().equalsIgnoreCase("zara coat 3"));
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector(".totalRow button")).click();
        driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
        List<WebElement> options =   driver.findElements(By.cssSelector(".ta-item"));

        for(  WebElement  option : options)
        {
            if(option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;


            }

        }

        //Actions a = new Actions(driver);
        //a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ta-results")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ta-results")));

        //driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        driver.findElement(By.cssSelector(".btnn")).click();
        String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));


    }
}
