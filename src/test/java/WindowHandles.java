import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
        WebElement link= driver.findElement(By.xpath("//a[@class='blinkingText'][1]"));
        link.click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> ids=windows.iterator();
        String parentID=ids.next();
        String childId=ids.next();
        driver.switchTo().window(childId);
        /***
        String message=driver.findElement(By.cssSelector(".im-para.red")).getText();
        System.out.println(message);
        //message=Please email us at mentor@rahulshettyacademy.com with below template to receive response
        String EmailID=message.split("at ")[1].split(" ")[0];
        System.out.println(EmailID);
        //finalString= mentor@rahulshettyacademy.com
         * We have split the string,but we can achieve the same with one line which I have used
         * String EmailID=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at ")[1].split(" ")[0];
         */
        String EmailID=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at ")[1].split(" ")[0];
        driver.switchTo().window(parentID);
        driver.findElement(By.cssSelector("input#username")).sendKeys(EmailID);
    }
}
