package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CheckBox_rahul_Shetty {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> options= driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("Total number of checkboxes: "+options.size());
        for( WebElement option: options){
            option.click();
            Assert.assertTrue(option.isSelected());
            if(option.isSelected()){
                option.click();
                Assert.assertFalse(option.isSelected());
            }
        }
    }
}
