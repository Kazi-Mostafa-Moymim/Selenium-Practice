package vegetableCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class filter {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                System.out.println("Switched to new tab: " + driver.getTitle());
                break;
            }
        }
        driver.findElement(By.id("search-field")).sendKeys("Rice");
         List<WebElement> veggis =driver.findElements(By.xpath("//tr/td[1]"));
         List<WebElement> firterVeggis = veggis.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(veggis.size(),firterVeggis.size());




    }
}







