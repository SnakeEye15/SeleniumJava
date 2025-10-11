package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class AutocompleteDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        String countName="india";
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("ind");
        Thread.sleep(2000);
        List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
        for(WebElement option : options){
            if(option.getText().equalsIgnoreCase(countName)){
                option.click();
            }
        }

        System.out.println(driver.findElement(By.id("autocomplete")).getText());
        driver.quit();
    }
}
