package vegetableCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class cart {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        String[] itemNeeded = {  "Cucumber", "Brocolli", "Beetroot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        cart c = new cart();
        c.addItems(driver, itemNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        driver.findElement(By.className("promoBtn")).click();

        System.out.println(driver.findElement(By.className("promoInfo")).getText());

        driver.findElement(By.xpath("//button[text()='Place Order']")).click();






    }

    public void addItems(WebDriver driver, String[] itemNeeded) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {

            String[] name = products.get(i).getText().split(" - ");
            String newName = name[0].trim();

            List itemNeededList = Arrays.asList(itemNeeded);

            if (itemNeededList.contains(newName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemNeeded.length) {
                    break;
                }

            }

        }

    }

}

