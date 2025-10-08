package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.Iterator;
import java.util.Set;

public class WindowHandlesAssignment {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        Actions a = new Actions(driver);
        WebElement windowHandleText=driver.findElement(By.xpath("//a[@href='/windows']"));
        a.scrollToElement(windowHandleText).build().perform();
        windowHandleText.click();
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> tabs= windows.iterator();
        String parentID=tabs.next();
        String childId=tabs.next();

        driver.switchTo().window(childId);
        String childMessage=driver.findElement(By.xpath("//h3")).getText();
        System.out.println(childMessage);
        driver.switchTo().window(parentID);
        String parentMessage=driver.findElement(By.xpath("//h3")).getText();
        System.out.println(parentMessage);

    }
}
