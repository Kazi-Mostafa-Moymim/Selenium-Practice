package Bropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.stream.Collectors;

public class bropDownPractice {
    @Test
    public  void dB () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(3000);
        List<WebElement> options =   driver.findElements(By.cssSelector("li[class='ui-menu-item'] a  "));

        for(  WebElement  option : options)
        {
            if(option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;


            }

        }
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@value='CCU'])[2]")).click();
        driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-active']")).click();

        Thread.sleep(2000L);

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);
        for(int i = 1;i<5;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }


        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select (staticDropdown);
        dropdown.selectByIndex(1);
        System.out.println( dropdown.getFirstSelectedOption().getText());

        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();





    }
}
