package Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class cartPractice {
  @Test
   public void cart(){
      String[] itemNeeded ={ "Cucumber", "Brocolli", "Beetroot"};
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      driver.get("https://rahulshettyacademy.com/seleniumPractise/");
      List<WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));
      for (int i=0;i< products.size();i++)
      {
          String[] name = products.get(i).getText().split("-");
          String newName = name[0].trim();
          int j = 0;
          List itemNeededList = Arrays.asList(itemNeeded);
          if(itemNeededList.contains(newName))
          {
              j++;
              driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
              if(j== itemNeeded.length)
              {
                  break;
              }
          }
      }
      driver.findElement(By.cssSelector("img[alt='Cart']")).click();
      driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
      driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
      driver.findElement(By.cssSelector(".promoBtn")).click();
      System.out.println(driver.findElement(By.className("promoInfo")).getText());
      driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();


  }

}
