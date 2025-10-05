import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class locators {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","/Users/dheerajv/Drivers/chromedriver-mac-arm64/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("sainidheeraj913");
        driver.findElement(By.name("inputPassword")).sendKeys("123421");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.cssSelector("p.error")).click();
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Dheeraj Saini");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Sainidheeraj913@gmail.com");
        driver.findElement(By.xpath("//input[@type=\"text\"][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("sainidheeraj913@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("8053329648");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("sainidheeraj913@gmail.com");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("#chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
        driver.quit();

    }
}

