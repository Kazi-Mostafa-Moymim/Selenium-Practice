package vegetableCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class tableSorting {

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
           driver.findElement(By.xpath("//tr/th[1]")).click();
            List<WebElement> allElement= driver.findElements(By.xpath("//tr/td[1]"));
           List<String>  orginalList = allElement.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String>  sortedlList = orginalList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(orginalList,sortedlList);
        List<String>price;
        do {
            List<WebElement> row= driver.findElements(By.xpath("//tr/td[1]"));
            price =  row.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a->System.out.println(a));
            if(price.size()<1)
            {
               driver.findElement(By.cssSelector("[aria-label='Next'")).click();
            }
        }while (price.size()<1);
        driver.switchTo().window(originalWindow);
        System.out.println(driver.getTitle());



    }

    private static String getPriceVeggie(WebElement s) {
         String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}

