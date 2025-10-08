package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class FrameAssignment {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        Actions a = new Actions(driver);
        WebElement nestedFrames=driver.findElement(By.xpath("//a[@href='/nested_frames']"));
        a.moveToElement(nestedFrames);
        nestedFrames.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
        String message= driver.findElement(By.id("content")).getText();
        System.out.println(message);

    }
}
