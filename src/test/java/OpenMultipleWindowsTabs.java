import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class OpenMultipleWindowsTabs {
    public static void main(String[] args) throws IOException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //Opening new tab in opened webdriver
        driver.switchTo().newWindow(WindowType.TAB);
        //ha
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> tabs= windows.iterator();
        String parentID=tabs.next();
        String childId=tabs.next();

        driver.switchTo().window( childId);
        driver.get("https://rahulshettyacademy.com/");
        String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
                .get(1).getText();

        driver.switchTo().window(parentID);
        WebElement name=driver.findElement(By.cssSelector("[name='name'] "));
        name.sendKeys(courseName);


        //we have new Functionality of taking screenshot of any webElement only So lets see only.

        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("/Users/dheerajv/SeleniumJava/src/test/java/Screenshots/logo.png"));


        //How to get the width and Height of webElements
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());


        driver.quit();
    }
}
