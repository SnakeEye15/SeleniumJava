import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class frameDemo {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
       // driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        driver.switchTo().frame(0);
        Actions a = new Actions(driver);
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droppable"));
        a.dragAndDrop(source,target).build().perform();
        driver.switchTo().defaultContent();

    }
}
